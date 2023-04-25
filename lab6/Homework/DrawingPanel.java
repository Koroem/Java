package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    public List<Edge> edges;
    private boolean player1Turn;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        this.player1Turn = true;
        init();
        resetGame();
    }

    private void init() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                for (Edge edge : edges) {
                    if (frame.configPanel.distanceToLine(e.getPoint(), edge.getStart(), edge.getEnd()) < 5.0) {
                        if (edge.getColor() == Color.GRAY) {
                            edge.setColor(player1Turn ? Color.BLUE : Color.RED);
                            player1Turn = !player1Turn;
                            repaint();

                            Color playerColor = player1Turn ? Color.RED : Color.BLUE;
                            if (frame.configPanel.isTriangleFormed(playerColor, edges)) {
                                JOptionPane.showMessageDialog(frame, (player1Turn ? "Player 2" : "Player 1") + " wins!");
                                resetGame();
                            }
                        }
                        break;
                    }
                }
            }
        });
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public void resetGame() {
        int numDots = (int) frame.configPanel.dotsSpinner.getValue();
        List<Point> points = frame.configPanel.generatePointsOnCircle(numDots);
        edges = frame.configPanel.generateEdges(points);
        player1Turn = true;
        setEdges(edges);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));

        for (Edge edge : edges) {
            g2d.setColor(edge.getColor());
            g2d.drawLine(edge.getStart().x, edge.getStart().y, edge.getEnd().x, edge.getEnd().y);
        }
    }
}
