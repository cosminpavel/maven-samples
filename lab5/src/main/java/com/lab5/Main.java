package com.lab5;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cosmin on 12/12/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        int port1 = 4444;
        int port2 = 4445;
        Map<String, Integer>  userLists= new HashMap<>();
        userLists.put("ionut",4444);
        userLists.put("andrei",4445);
        userLists.put("mihai",4446);

        UserThread userThread = new UserThread(userLists,"ionut");
        userThread.run();


    }
}
