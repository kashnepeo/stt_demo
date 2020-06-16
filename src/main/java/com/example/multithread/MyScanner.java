package com.example.multithread;

import java.util.Scanner;

public class MyScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //여기서 블로킹 됨
        String str = sc.nextLine();

        System.out.println(str);
        System.out.println("안녕!");

    }
}
