
package io.bio;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class BIOServer {


    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("service start ......");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("client " + socket.getInetAddress().getHostAddress() + " come in");
                new Thread(() -> {
                    try {
                        InputStream inputStream = socket.getInputStream();
                        PrintStream printStream = new PrintStream(socket.getOutputStream());
                        Scanner in = new Scanner(inputStream);
                        in.useDelimiter("\n");
                        while (in.hasNext()) {
                            String message = in.next().trim();
                            if (message.equalsIgnoreCase("bye")) {
                                String bye = new String("client by by".getBytes("UTF-8"));
                                System.out.println(bye);
                                printStream.println(bye);
                            } else {
                                printStream.println("ECHO>" + message);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}