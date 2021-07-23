package io.nio.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * 1. 我们自定义handler 需要继承 Netty规划好的某个handlerAdapter（有很多规范）
 * 2. 这时我们自定义的handler 才能称为一个handler
 */
@ChannelHandler.Sharable
public class NettyServerHandler extends ChannelInboundHandlerAdapter {


    private static AtomicInteger count = new AtomicInteger();

    /**
     * 可以读取客户端发送的消息
     * ChannelHandlerContext 上下文对象 含有管道pipeline 通道channel 地址
     * Object 客户端发送的数据
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        int i = count.incrementAndGet();

        System.out.println("server ctx : " + ctx + " c : " + i);



        //这里异步执行， NIOEventLoop 的 taskQueue
       /* ctx.channel().eventLoop().execute(()->{
            try {
                Thread.sleep(5*1000);
                ctx.writeAndFlush(Unpooled.copiedBuffer("hello client 喵" , Charset.defaultCharset()));
            }catch (Exception e){
                e.printStackTrace();
            }
        });*/

       /* ctx.channel().eventLoop().schedule(()->{
            try {
                Thread.sleep(5*1000);
                ctx.writeAndFlush(Unpooled.copiedBuffer("hello client 喵1" , Charset.defaultCharset()));
            }catch (Exception e){
                e.printStackTrace();
            }
        } , 5 , TimeUnit.SECONDS);*/

        ByteBuf byteBuffer = (ByteBuf) msg;
        //System.out.println("client msg : " + byteBuffer.toString(Charset.defaultCharset()));
        System.out.println("客户端地址: " + ctx.channel().remoteAddress());

    }

    /**
     * 数据读取完毕
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello client" , Charset.defaultCharset()));
    }

    //一般关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        //两者都行
        ctx.channel().close();
        //ctx.close();

    }
}
