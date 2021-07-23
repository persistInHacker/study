package io.nio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

public class NettyByteBufTest {

    public static void main(String[] args) {


        /*
        在netty中的buffer中 不需要flip
        底层维护了一个 readerIndex 和 writerIndex
         */
        ByteBuf buffer = Unpooled.buffer(10);

        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.writeByte(i);
        }


        for (int i = 0; i < 10; i++) {
            System.out.println(buffer.readByte());
        }



    }


}
