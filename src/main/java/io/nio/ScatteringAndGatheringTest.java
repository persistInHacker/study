package io.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * Scattering:  将数据写入到buffer时，可以采用buffer数组，依次写入，（分散）
 * Gathering: 从buffer读取数据时候，，可以采用buffer数组，依次读
 */
public class ScatteringAndGatheringTest {

    public static void main(String[] args) throws Exception{

        ServerSocketChannel open = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);

        open.socket().bind(inetSocketAddress);

        ByteBuffer [] b = new ByteBuffer[2];
        b[0] = ByteBuffer.allocate(5);
        b[1] = ByteBuffer.allocate(3);

        SocketChannel accept = open.accept();
        int msgLen = 8;

        while (true){

            int byteRead = 0;
            while (byteRead < msgLen){

                long l = accept.read(b);
                byteRead += l;//累计读取的字节数
                System.out.println("byteRead = " + byteRead);

                Arrays.asList(b).stream().map(buffer -> "postion=" +
                        buffer.position() + " ,limit=" + buffer.limit()).forEach(System.out::println);
            }

            //将所有buffer flip
            Arrays.asList(b).forEach(byteBuffer -> byteBuffer.flip());

            //将数据读出显示到客户端
            long byteWrite = 0;
            while (byteWrite < msgLen){
                long l = accept.write(b);
                byteWrite += l;
            }

            Arrays.asList(b).forEach(byteBuffer -> byteBuffer.clear());

            System.out.println("byteRead:=" + byteRead +" byteWrite:=" + byteWrite + " msglen" +msgLen);

        }


    }

}
