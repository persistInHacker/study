package io.nio.netty.groupchat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import io.nio.netty.simple.NettyServerHandler;

import java.util.concurrent.TimeUnit;

public class GroupChatServer {

    public static void main(String[] args) throws InterruptedException {


        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();

            bootstrap.group(bossGroup , workGroup) //设置两个线程组
                    .channel(NioServerSocketChannel.class)    //使用NioSocketChannel 作为服务器的通道实现
                    .option(ChannelOption.SO_BACKLOG , 128) //设置线程队列得到连接个数
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childOption(ChannelOption.SO_KEEPALIVE , true)  //设置保持活动连接状态
                    .childHandler(new ChannelInitializer<SocketChannel>() {//创建一个通道测试对象
                        //给pipeline 设置处理器
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {

                            ChannelPipeline pipeline = ch.pipeline();

                            /*
                                处理空闲状态的处理器
                                1、多长时间没有读，发送心跳包
                                2、多长时间没有写
                                3、多长时间没有读写
                                4、allIdleTime
                                    an {@link IdleStateEvent} whose state is {@link IdleState#ALL_IDLE}
                                    will be triggered when neither read nor write was performed for
                                    the specified period of time.  Specify {@code 0} to disable.
                                5、当IdleStateEvent触发后，将会传递给管道的下一个handler去处理，通过调用下一个handler的userEventTriggered

                             */
                            pipeline.addLast(new IdleStateHandler(3,5,7, TimeUnit.SECONDS));
                            //加入对空闲检测进一步处理的handler
                            pipeline.addLast(new GroupChatIdleHandler());

                            pipeline.addLast("decoder" , new StringDecoder());
                            pipeline.addLast("encoder" , new StringEncoder());
                            pipeline.addLast(new GroupChatServerHandler());
                        }
                    }); // 给 workGroup 的 eventLoop 对应的管道设置处理器

            System.out.println("服务器准备好了");

            ChannelFuture sync = bootstrap.bind(8888).sync();
            sync.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if(future.isSuccess()){
                        System.out.println("绑定端口成功");
                    }else{
                        System.out.println("绑定失败");
                    }
                }
            });


            //对关闭通道的事件进行监听
            sync.channel().closeFuture().sync();
        }finally {
            //优雅关闭
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }

}
