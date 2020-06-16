package com.example.multithread;

import java.net.ServerSocket;

public class SttServer {
    public static void main(String[] args) {
        try {
            System.out.println("접속을 기다립니다.");
            ServerSocket serverSocket = new ServerSocket(5566);
            AcceptThread acceptThread = new AcceptThread(serverSocket);

            // 여기서 새로운 쓰레드가 생성
            new Thread(acceptThread).start();

            // 아래 구문과 동시에 실행이 됨.
            System.out.println("STT Server Starts!");


            // 다중클라이언트를 처리하는 메신저라든지

        } catch (Exception e) {
        }
    }
}
