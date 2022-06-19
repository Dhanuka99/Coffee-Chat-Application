package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        System.out.println("Waiting for client");
        try {
            ServerSocket serverSocket = new ServerSocket(9064);
            Socket socket = serverSocket.accept();
            System.out.println("connection established..");
            //server receive message from client
            InputStreamReader in = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(in);
            String s = bufferedReader.readLine();
            System.out.println("Client : "+s);

            //server send message to client
            PrintWriter input = new PrintWriter(socket.getOutputStream());
            System.out.println("Enter Server message");
            Scanner scanner = new Scanner(System.in);
            String s1 = scanner.nextLine();
            input.println(s1);
            input.flush();




        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
