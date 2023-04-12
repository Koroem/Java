package org.example;
import java.util.*;
public class Map {

        private final Cell[][] matrix;

        public Map(int n) {
            matrix = new Cell[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = new Cell();
                }
            }
        }

        public boolean visit(int row, int col, Robot robot, Memory memory) {
            Cell cell = matrix[row][col];
            synchronized (cell) {
                if (!cell.isVisited()) {
                    List<Token> tokens = memory.extractTokens(robot.getTokensPerVisit());
                    cell.setTokens(tokens);
                    System.out.println(robot.getName() + " visited cell [" + row + ", " + col + "] and placed tokens: " + tokens);
                    return true;
                }
            }
            return false;
        }
    public boolean allCellsVisited() {
        for (Cell[] row : matrix) {
            for (Cell cell : row) {
                if (!cell.isVisited()) {
                    return false;
                }
            }
        }
        return true;
    }

        public int getSize() {
            return matrix.length;
        }
        public void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Cell cell = matrix[i][j];
                List<Token> tokens = cell.getTokens();
                System.out.print("[" + i + "," + j + "]: ");
                System.out.println(tokens);
            }
        }
    }
    }


