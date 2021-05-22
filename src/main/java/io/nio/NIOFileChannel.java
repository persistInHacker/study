package io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel {


    public static void main(String[] args) throws Exception {
//        write();
//
//        read();

        readWrite();
    }

    private static void readWrite()  throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\test.txt");
        FileChannel inputStreamChannel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\test1.txt");
        FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();

        ByteBuffer allocate = ByteBuffer.allocate(1024);

        while (true){

            allocate.clear();
            int read = inputStreamChannel.read(allocate);
            if(read == -1){
                break;
            }
            allocate.flip();
            fileOutputStreamChannel.write(allocate);
        }


    }

    private static void read() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\test.txt");
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        FileChannel channel = fileInputStream.getChannel();
        channel.read(allocate);
        System.out.println(new String(allocate.array()));
    }

    private static void write() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\test.txt");
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        String str = "hello world!";
        byteBuffer.put(str.getBytes());
        byteBuffer.flip();
        FileChannel channel = fileOutputStream.getChannel();
        channel.write(byteBuffer);
        channel.close();
    }


}
