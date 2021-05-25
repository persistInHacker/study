package io.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 直接在堆外内存修改
 */
public class MappedByteBufferTest {


    public static void main(String[] args) throws IOException {

        RandomAccessFile randomAccessFile = new RandomAccessFile("1.txt", "rw");

        FileChannel channel = randomAccessFile.getChannel();

        /*
            FileChannel.MapMode.READ_WRITE, 读写模式
            参数2：可以修改的起始位置
            参数3：映射到内存的大小，即多少个字节映射到内存
            可以直接修改的范围是0-5
         */
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        map.put(0, (byte) 'a');
        map.put(1, (byte) 'b');
        map.put(2, (byte) 'c');
        randomAccessFile.close();

    }

}
