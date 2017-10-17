package com.lab1;

import java.util.Scanner;

/**
 * Created by Cosmin on 10/3/2017.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String bla;

        Operations operations = new Operations();
        Calculator calculator = new Calculator(operations);
        while(true) {
            bla = scanner.next();
            System.out.println("=" + calculator.operationParser(bla));
        }

    }
}
