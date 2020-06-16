package com.example.multithread;

import java.net.ServerSocket;
import java.net.Socket;

public class MyAccept {

    public static void main(String[] args) {

        while (true) {
            try {
                System.out.println("서버 스타트!.. 클라이언트의 접속을 기다립니다.");
                ServerSocket serverSocket = new ServerSocket(10002);

                // 여기서 블로킹됨
                Socket client = serverSocket.accept();
                System.out.println("클라이언트 접속 " + client);

                // 1:1에서는 문제가 발생하지 않음.
                // 다중 클라이언트를 처리하는 프로그램에서

                // read, write 특정 상황에서만 값을 보내주는 기능을 해야할 때 문제
            } catch (Exception e) {
            }
        }


        // 다른작업 수행 불가
        // System.out.println("뭔갈 해야하는데..");
    }
}