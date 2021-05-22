package io.nio;

import java.nio.IntBuffer;

public class IntTest {


    public static void main(String[] args) {

        IntBuffer ib = IntBuffer.allocate(5);
        //这里只能放入5个值
        for (int i = 0; i < 5; i++) {
            ib.put(i);
        }

        //读写通道反转
        ib.flip();

        while (ib.hasRemaining()){
            System.out.println(ib.get());
        }



    }


}
