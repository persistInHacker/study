package io.nio.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;
import io.nio.netty.groupchat.GroupChatIdleHandler;
import io.nio.netty.groupchat.GroupChatServerHandler;

import java.util.concurrent.TimeUnit;

public class WebSocketServer {

    public static void main(String[] args) throws InterruptedException {


        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();

            bootstrap.group(bossGroup, workGroup) //设置两个线程组
                    .channel(NioServerSocketChannel.class)    //使用NioSocketChannel 作为服务器的通道实现
                    .option(ChannelOption.SO_BACKLOG, 128) //设置线程队列得到连接个数
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childOption(ChannelOption.SO_KEEPALIVE, true)  //设置保持活动连接状态
                    .childHandler(new ChannelInitializer<SocketChannel>() {//创建一个通道测试对象
                        //给pipeline 设置处理器
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {

                            ChannelPipeline pipeline = ch.pipeline();

                            //因为是基于http协议，使用http的编码和解码器
                            pipeline.addLast(new HttpServerCodec());
                            //是以块方式写，添加这个handler
                            pipeline.addLast(new ChunkedWriteHandler());
                            /*
                                http数据在传输中是分段的，HttpObjectAggregator可以将多个段聚合起来
                                这就是为什么当浏览器发送大量数据的时候，会发送多次Http请求
                             */
                            pipeline.addLast(new HttpObjectAggregator(8192));

                            /*
                                1、websocket，它的数据是以帧的形式传递
                                2、WebSocketFrame 有6个子类
                                3、浏览器发送请求时候 ws://localhost:7000/hello 请求的URI
                                4、WebSocketServerProtocolHandler核心功能是将Http协议升级为ws协议，保持长连接
                             */
                            pipeline.addLast(new WebSocketServerProtocolHandler("/hello"));

                            //自定义Handler 处理业务逻辑
                            pipeline.addLast(new WebSocketServerHandler());
                        }
                    });

            System.out.println("服务器准备好了");

            ChannelFuture sync = bootstrap.bind(8888).sync();
            sync.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (future.isSuccess()) {
                        System.out.println("绑定端口成功");
                    } else {
                        System.out.println("绑定失败");
                    }
                }
            });


            //对关闭通道的事件进行监听
            sync.channel().closeFuture().sync();
        } finally {
            //优雅关闭
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }

}
