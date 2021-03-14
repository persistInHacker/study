package io.nio;

public class NIOFileChannel {


    public static void main(String[] args) {

        int i [] = {3300,
                3300,
                2700,
                2700,
                1200,
                1200,
                3300,
                300,
                300,
                1200,
                600};
        int r = 0;
        for (int i1 : i) {
            r += i1;

        }
        System.out.println(r);

    }


}
