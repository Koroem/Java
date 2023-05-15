package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket clientSocket;

    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        //read from the socket
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             //write to the socket
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);

                if ("stop".equals(inputLine)) {
                    out.println("Server stopped");
                    System.exit(0);
                } else {
                    out.println("Server received the request: " + inputLine);
                }
            }
        } catch (IOException e) {
            System.err.println("Error in ClientThread: " + e.getMessage());
        }
    }
}

