package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    private int port;
    private boolean running = true;

    public GameServer(int port) {
        this.port = port;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Game server started on port " + port);

            while (running) {
                // TCP
                Socket clientSocket = serverSocket.accept();
                // pasam descriptorul de thread la constructrul din clasa ClientThread
                ClientThread clientThread = new ClientThread(clientSocket);
                clientThread.start();
            }
        } catch (IOException e) {
            System.err.println("Error starting server: " + e.getMessage());
        }
    }

}
