package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {

    final MainFrame frame;
    final static int W = 800, H = 600;

    List<Point2D> points;
    int[][] lines;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        initPanel();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (points != null && lines != null) {
            // Draw lines
            g2d.setColor(Color.GRAY);
            for (int[] line : lines) {
                Point2D p1 = points.get(line[0]);
                Point2D p2 = points.get(line[1]);
                g2d.drawLine((int) p1.getX(), (int) p1.getY(), (int) p2.getX(), (int) p2.getY());
            }

            // Draw dots
            g2d.setColor(Color.BLACK);
            int dotRadius = 5;
            for (Point2D point : points) {
                int x = (int) point.getX() - dotRadius;
                int y = (int) point.getY() - dotRadius;
                g2d.fillOval(x, y, 2 * dotRadius, 2 * dotRadius);
            }
        }
    }

    public void drawGraph(int numDots, int numLines) {
        points = generatePoints(numDots);
        lines = generateLines(numDots, numLines);
        repaint();
    }

    private List<Point2D> generatePoints(int numDots) {
        List<Point2D> points = new ArrayList<>();
        double angle = 2 * Math.PI / numDots;
        double centerX = W / 2.0;
        double centerY = H / 2.0;
        double radius = Math.min(W, H) * 0.4;

        for (int i = 0; i < numDots; i++) {
            double x = centerX + radius * Math.cos(i * angle);
            double y = centerY + radius * Math.sin(i * angle);
            points.add(new Point2D.Double(x, y));
        }

        return points;
    }

    private int[][] generateLines(int numDots, int numLines) {
        int[][] lines = new int[numLines][2];
        int lineCount = 0;

        for (int i = 0; i < numDots && lineCount < numLines; i++) {
            for (int j = i + 1; j < numDots && lineCount < numLines; j++) {
                lines[lineCount][0] = i;
                lines[lineCount][1] = j;
                lineCount++;
            }
        }

        return lines;
    }
}