package com.example.socket;

//import org.json.simple.JSONArray;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;

import jdk.nashorn.internal.parser.JSONParser;

import java.io.*;
import java.net.Socket;

class EchoHandler extends Thread {
    Socket client;
//    JSONArray jsonArray;

    EchoHandler (Socket client) {
        this.client = client;
        dataSetting();
    }

    public void run () {
        try {


            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
            writer.println("[type 'bye' to disconnect]");

            while (true) {
                String line = reader.readLine();
                if (line.trim().equals("bye")) {
                    writer.println("bye!");
                    break;
                }

//                for (int i = 0; i < jsonArray.size(); i++) {
//                    String sendData = jsonArray.get(i).toString();
//                    writer.println("[echo] " + sendData);
//                }

            }
        }
        catch (Exception e) {
            System.err.println("Exception caught: client disconnected.");
        }
        finally {
            try { client.close(); }
            catch (Exception e ){ ; }
        }
    }

    public void dataSetting() {
//        JSONParser parser = new JSONParser();
//        try {
//            jsonArray = (JSONArray) parser.parse(new FileReader("sample/sample.json"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }
}
