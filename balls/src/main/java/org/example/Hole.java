package org.example;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Hole {
    private Component canvas;

    public int getXSIZE() {
        return XSIZE;
    }

    public int getYSIZE() {
        return YSIZE;
    }

    private final int XSIZE = 20;
    private final int YSIZE = 20;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int x = 0;
    private int y= 0;

    public Hole(Component canvas) {
        this.canvas = canvas;
    }

    public Hole(Component canvas, int x, int y) {
        this.canvas = canvas;
        this.x = x;
        this.y = y;
    }

    public void draw (Graphics2D g2){

        g2.draw(new Ellipse2D.Double(x,y,XSIZE,YSIZE));

    }
}
