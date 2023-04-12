package org.example;

import java.util.*;

public class Robot implements Runnable {
    private final String name;
    private final Map map;
    private final Memory memory;
    private final int tokensPerVisit;
    private boolean running;
    private boolean canPrint;

    public Robot(String name, Map map, Memory memory, int tokensPerVisit,boolean canPrint) {
        this.name = name;
        this.map = map;
        this.memory = memory;
        this.tokensPerVisit = tokensPerVisit;
        this.running = true;
        this.canPrint=canPrint;
    }

    public String getName() {
        return name;
    }

    public int getTokensPerVisit() {
        return tokensPerVisit;
    }

    @Override
    public void run() {
        Random random = new Random();
        int size = map.getSize();
        while (running) {
            int row = random.nextInt(size);
            int col = random.nextInt(size);
            map.visit(row, col, this, memory);
            if (map.allCellsVisited()) {
                System.out.println("All cells visited. Stopping " + getName() + ".");
                if(canPrint)
                    map.printMatrix();
                break;
            }
            try {
                Thread.sleep(random.nextInt(1000) + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

