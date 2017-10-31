package com.lab1;

import java.util.Scanner;

/**
 * Created by Cosmin on 10/3/2017.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String bla;
        Calculator calculator = new Calculator();

        System.out.println(calculator.operationParser("1 + 2"));

    }
}
