package io.nio.netty.simple;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {


    public static void main(String[] args) throws InterruptedException {

        //客户端需要一个事件循环组
        EventLoopGroup eventExecutors = new NioEventLoopGroup();

        for (int i = 0; i < 10_0000; i++) {
            link(eventExecutors);
            Thread.sleep(1);
        }

    }

    private static void link(EventLoopGroup eventExecutors) throws InterruptedException {
       // try{
            Bootstrap bootstrap = new Bootstrap();

            bootstrap.group(eventExecutors)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new NettyClientHandler());
                        }
                    });

            System.out.println("client ok");

            ChannelFuture sync = bootstrap.connect("172.23.127.162", 8888).sync();

            //sync.channel().closeFuture().sync();
//        }finally {
//            eventExecutors.shutdownGracefully();
//        }
    }
}
