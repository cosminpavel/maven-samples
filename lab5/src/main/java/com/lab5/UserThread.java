package com.lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserThread implements Runnable {
    public ServerSocket serverSocket;
    public String username;
    public Map<String,Integer> userList;
    public Map<String, Socket> connections = new ConcurrentHashMap<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public UserThread(Map<String ,Integer> userList,String username) throws IOException {
        this.userList = userList;
        this.username = username;
        serverSocket = new ServerSocket(userList.get(username));
    }
    @Override
    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Runnable taskWrite = () ->handleWrite();
        executorService.execute(taskWrite);
        while(true){
            try {
                Socket clientSocket = serverSocket.accept();
                Runnable task = ()-> handleRequest(clientSocket);
                executorService.execute(task);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleWrite() {
        while (true) {
            String msg = null;
            try {
                msg = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] split = msg.split(" ");
            if (msg != null) {
                try (Socket socket = new Socket("127.0.0.1", userList.get(split[split.length - 1]));
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()));
                ) {
                    int poz = msg.lastIndexOf(" ");
                    out.println(msg.substring(0,poz) + " " + username);
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void handleRequest(Socket socket) {
        try (PrintWriter out =
                     new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
        ) {
            String msg = in.readLine();
            int poz = msg.lastIndexOf(" ");
            String userWriter = msg.substring(poz + 1,msg.length() );
            connections.put(userWriter,socket);
            System.out.println(userWriter+ ":"+ msg.substring(0,poz));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String usernameByPort(Integer port){
        for (Map.Entry<String,Integer> entry : userList.entrySet()) {
            if(entry.getValue().equals(port)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
