package io.nio.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

public class NettyClientHandler extends ChannelInboundHandlerAdapter {


    private String str = "hello server";

    {

        for (int i = 0; i < 1000; i++) {
            str += "hello world";
        }

    }

    /**
     * 当通道就绪触发
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {



       while (true){

           ctx.writeAndFlush(Unpooled.copiedBuffer(str , Charset.defaultCharset()));
           Thread.sleep(1L);
       }

    }

    /**
     * 通道有读取事件时触发
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("服务器回复消息: " + byteBuf.toString(Charset.defaultCharset()));
        System.out.println("服务器地址: " + ctx.channel().remoteAddress());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        cause.printStackTrace();
        ctx.close();
    }
}
