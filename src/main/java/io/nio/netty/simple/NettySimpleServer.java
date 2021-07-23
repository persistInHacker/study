package io.nio.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettySimpleServer {

    public static void main(String[] args) throws InterruptedException {


        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();

            bootstrap.group(bossGroup , workGroup) //设置两个线程组
                    .channel(NioServerSocketChannel.class)    //使用NioSocketChannel 作为服务器的通道实现
                    .option(ChannelOption.SO_BACKLOG , 128) //设置线程队列得到连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE , true)  //设置保持活动连接状态
                    .childHandler(new ChannelInitializer<SocketChannel>() {//创建一个通道测试对象
                        //给pipeline 设置处理器
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {

                            ch.pipeline().addLast(new NettyServerHandler());
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
