package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient {
    private String serverAddress;
    private int serverPort;

    public GameClient(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public void start() {
        try (Socket socket = new Socket(serverAddress, serverPort);
             //read from socket
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             //write to socket
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             // read from keyboard
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            String userInput;
            while ((userInput = stdIn.readLine()) != null && !"exit".equalsIgnoreCase(userInput)&& !"\n".equals(userInput)) {
                out.println(userInput);
                System.out.println("Server response: " + in.readLine());
            }
        } catch (IOException e) {
            System.err.println("Error in GameClient: " + e.getMessage());
        }
    }
}
