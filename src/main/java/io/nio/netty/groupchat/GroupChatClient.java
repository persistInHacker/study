package io.nio.netty.groupchat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.nio.netty.simple.NettyClientHandler;

import java.util.Scanner;

public class GroupChatClient {



    public static void main(String[] args) throws InterruptedException {

        //客户端需要一个事件循环组
        EventLoopGroup eventExecutors = new NioEventLoopGroup();

        try{
            Bootstrap bootstrap = new Bootstrap();

            bootstrap.group(eventExecutors)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("decoder" , new StringDecoder());
                            pipeline.addLast("encoder" , new StringEncoder());
                            pipeline.addLast(new GroupChatClientHandler());
                        }
                    });

            System.out.println("client ok");

            ChannelFuture sync = bootstrap.connect("127.0.0.1", 8888).sync();

            Channel channel = sync.channel();

            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()){
                String s = scanner.nextLine();
                channel.writeAndFlush(s +"\r\n");
            }
            //sync.channel().closeFuture().sync();
        }  finally {
            eventExecutors.shutdownGracefully();
        }

    }



}
