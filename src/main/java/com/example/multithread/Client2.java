package com.example.multithread;

import java.io.DataInput;
import java.io.DataInputStream;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("133.186.171.47", 5566);
            long start = System.currentTimeMillis();
            while (true) {
                long end = System.currentTimeMillis();
                double result = (end - start) / 1000.0;
                System.out.println(result);
                if (result > 10) {
                    break;
                } else {
                    DataInputStream dis = new DataInputStream(socket.getInputStream());
                    System.out.println(dis.readUTF());
                    System.out.println("접속 성공!");
                    continue;
                }
            }
            System.out.println("접속 종료!");
        } catch (Exception e) {
        }
    }
}
