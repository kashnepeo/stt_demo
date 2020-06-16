package com.example.multithread;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.DataOutputStream;
import java.io.FileReader;
import java.net.ServerSocket;
import java.net.Socket;

public class AcceptThread implements Runnable {

    ServerSocket serverSocket;
    Socket client;
//    JSONArray jsonArray;
//    DataOutputStream dataOutputStream;

    public AcceptThread(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
//        dataSetting();
//        streamSetting();
    }

    @Override
    public void run() {
        while (true) {
            try {
                client = serverSocket.accept();
                JSONParser parser = new JSONParser();
                JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("sample/sample.json"));
                DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
                for (Object o : jsonArray) {
                    String sendData = o.toString();
                    dataOutputStream.writeUTF("[echo] " + sendData);
                }

                System.out.println("connected client : " + client);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

//    public void dataSetting() {
//        JSONParser parser = new JSONParser();
//        try {
//            jsonArray = (JSONArray) parser.parse(new FileReader("sample/sample.json"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    public void streamSetting() {
//        try {
//            dataOutputStream = new DataOutputStream(client.getOutputStream());
//        } catch (Exception e) {
//
//        }
//    }
}