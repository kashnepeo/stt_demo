package com.example.multithread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    private Socket clientSocket;

    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    // 1. 데이터를 계속 전송 쓰레드
    // 2. 데이터를 계속 수신 쓰레드
    public void connect() {
        try {
            System.out.println("접속 시도");
            clientSocket = new Socket("localhost", 5566);
            System.out.println("접속 완료");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dataRecv() {
        new Thread(new Runnable() {
            boolean isThread = true;

            @Override
            public void run() {
                while (isThread) {
                    try {
                        String recvData = dataInputStream.readUTF();
                        if (recvData.equals("/quit"))
                            isThread = false;
                        else
                            System.out.println("상대방 : " + recvData);
                    } catch (Exception e) {
                    }
                }
            }
        }).start();
    }


    public void dataSend() {
        new Thread(new Runnable() {
            boolean isThread = true;
            @Override
            public void run() {
                while (isThread) {
                    try {
                        String sendData = "client message";
                        if (sendData.equals("/quit"))
                            isThread = false;
                        else
                            dataOutputStream.writeUTF(sendData);
                    } catch (Exception e) {
                    }
                }
            }
        }).start();
    }


    public void streamSetting() {
        try {
            dataInputStream = new DataInputStream(clientSocket.getInputStream());
            dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
        } catch (Exception e) {

        }

    }


    public Client() {
        connect();
        streamSetting();
        dataSend();
        dataRecv();
    }


    public static void main(String[] args) {
        new Client();
    }

}