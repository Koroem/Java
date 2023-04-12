package org.example;

import java.util.*;

public class Supervisor {
    private final List<Robot> robots;

    public Supervisor() {
        this.robots = new ArrayList<>();
    }

    public void addRobot(Robot robot) {
        robots.add(robot);
    }

    public void start() {
        for (Robot robot : robots) {
            new Thread(robot).start();
        }
    }
}

