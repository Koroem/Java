package org.example;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;

public class Edge implements Serializable {
    private Point start;
    private Point end;
    private Color color;

    public Edge(Point start, Point end, Color color) {
        this.start = start;
        this.end = end;
        this.color = color;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


}
