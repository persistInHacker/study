
package io.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;


public class NIOServer {


    public static void main(String[] args) throws IOException, InterruptedException {

        LinkedList<SocketChannel> clients = new LinkedList<>();

        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress(9090));
        ss.configureBlocking(false);// NONBLOCKING 只让接收客户端不阻塞

        while (true) {
            Thread.sleep(1000);
            SocketChannel client = ss.accept();
            if (client == null) {
                System.out.println("null");
            } else {
                client.configureBlocking(false);//
                int port = client.socket().getPort();
                System.out.println("client port : " + port);
                clients.add(client);

            }

            ByteBuffer buffer = ByteBuffer.allocateDirect(4096);

            for (SocketChannel c : clients) {
                int read = c.read(buffer);
                if (read > 0) {
                    buffer.flip();
                    byte[] aaa = new byte[buffer.limit()];
                    buffer.get(aaa);

                    String s = new String(aaa);
                    System.out.println(c.socket().getPort() + " : " + s);
                    buffer.clear();
                }
            }
        }
    }
}