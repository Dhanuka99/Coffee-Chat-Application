package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        try {
            System.out.println("client started..");
            Socket socket = new Socket("localhost", 9064);
            //client send the message
            PrintWriter input = new PrintWriter(socket.getOutputStream());

            System.out.println("Enter Client message");
            Scanner scanner = new Scanner(System.in);
            String s1 = scanner.nextLine();
            input.println(s1);
            input.flush();

            //client receive message from server
            InputStreamReader in = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(in);
            String s = bufferedReader.readLine();
            System.out.println("Server : "+s);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
