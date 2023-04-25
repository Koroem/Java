package org.example;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel drawingPanel;

    public MainFrame() {
        super("1V1");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        /* nr noduri si linii */
        configPanel = new ConfigPanel(this);
        /* butoane */
        controlPanel = new ControlPanel(this);
        /* desenare graf */
        drawingPanel = new DrawingPanel(this);

        add(configPanel, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
}
