package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;


    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        dotsLabel = new JLabel("Dots:");
        linesLabel = new JLabel("Lines:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        linesCombo = new JComboBox();
        createButton = new JButton("Create");

        createButton.addActionListener((ActionEvent e) -> frame.drawingPanel.resetGame());

        add(dotsLabel);
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);
    }

    List<Point> generatePointsOnCircle(int numPoints) {
        int panelRadius = 200;
        int centerX = frame.getWidth() / 2;
        int centerY = frame.getHeight() / 2;

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < numPoints; i++) {
            double angle = 2 * Math.PI * i / numPoints;
            int x = centerX + (int) (panelRadius * Math.cos(angle));
            int y = centerY + (int) (panelRadius * Math.sin(angle));
            points.add(new Point(x, y));
        }

        return points;
    }

    List<Edge> generateEdges(List<Point> points) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                edges.add(new Edge(points.get(i), points.get(j), Color.GRAY));
            }
        }
        return edges;
    }

    double distanceToLine(Point p, Point a, Point b) {
        double numerator = Math.abs((b.y - a.y) * p.x - (b.x - a.x) * p.y + b.x * a.y - b.y * a.x);
        double denominator = Math.sqrt(Math.pow(b.y - a.y, 2) + Math.pow(b.x - a.x, 2));
        return numerator / denominator;
    }

    public boolean isTriangleFormed(Color playerColor, List<Edge> edges) {
        Set<Point> playerPoints = new HashSet<>();
        for (Edge edge : edges) {
            if (edge.getColor() == playerColor) {
                playerPoints.add(edge.getStart());
                playerPoints.add(edge.getEnd());
            }
        }

        if (playerPoints.size() < 3) {
            return false;
        }

        List<Point> playerPointList = new ArrayList<>(playerPoints);
        int n = playerPointList.size();
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (playerHasEdge(playerColor, edges, playerPointList.get(i), playerPointList.get(j)) &&
                            playerHasEdge(playerColor, edges, playerPointList.get(j), playerPointList.get(k)) &&
                            playerHasEdge(playerColor, edges, playerPointList.get(k), playerPointList.get(i))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean playerHasEdge(Color playerColor, List<Edge> edges, Point p1, Point p2) {
        for (Edge edge : edges) {
            if (edge.getColor() == playerColor && ((edge.getStart().equals(p1) && edge.getEnd().equals(p2)) ||
                    (edge.getStart().equals(p2) && edge.getEnd().equals(p1)))) {
                return true;
            }
        }
        return false;
    }

    void loadGame(DrawingPanel drawingPanel) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                FileInputStream fis = new FileInputStream(fileChooser.getSelectedFile());
                ObjectInputStream ois = new ObjectInputStream(fis);
                List<Edge> edges = (List<Edge>) ois.readObject();
                drawingPanel.setEdges(edges);
                drawingPanel.repaint();
                ois.close();
                fis.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    void saveGame(List<Edge> edges) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                FileOutputStream fos = new FileOutputStream(fileChooser.getSelectedFile());
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(edges);
                oos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
