package com.twinkleroot.javacodingstudy;

import java.util.Scanner;

public class RegisterMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputNo = scanner.nextInt();

        for(int i=1;i<10;i++) {
            System.out.println(inputNo + " * " + i + " = " + inputNo*i);
        }
    }
}
