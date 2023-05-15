package org.example;

public class Main {
    public static void main(String[] args) {
        int port = 8081;
        GameServer gameServer = new GameServer(port);
        gameServer.start();
    }

}