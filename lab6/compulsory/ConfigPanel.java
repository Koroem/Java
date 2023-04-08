package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;

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
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        linesLabel = new JLabel("Number of lines:");
        linesCombo = new JComboBox();
        for (int i = 1; i <= 9900; i++) {
            linesCombo.addItem(i);
        }
        createButton = new JButton("Create New Game");
        createButton.addActionListener(this::createNewGame);

        add(dotsLabel);
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);
    }

    private void createNewGame(ActionEvent e) {
        int numDots = (int) dotsSpinner.getValue();
        int numLines = (int) linesCombo.getSelectedItem();
        frame.canvas.drawGraph(numDots, numLines);
    }

}

