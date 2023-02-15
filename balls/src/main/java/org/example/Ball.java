package org.example;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Ball {
    private Component canvas;
    private static final int XSIZE = 20;
    private static final int YSIZE = 20;
    private int x = 0;
    private int y= 0;
    private int dx = 2;
    private int dy = 2;

    private static int lastId = 0;

    public int getId() {
        return id;
    }

    private int id;
    public void setColor(Color color) {
        this.color = color;
    }

    private Color color = Color.darkGray;

    public Ball(Component c){
        this.canvas = c;
        this.id = ++lastId;
        if(Math.random()<0.5){
            x = new Random().nextInt(this.canvas.getWidth());
            y = 0;
        }else{
            x = 0;
            y = new Random().nextInt(this.canvas.getHeight());
        }
    }
    public Ball(Component c, Color color){
        this.canvas = c;
        this.id = ++lastId;
        if(Math.random()<0.5){
            x = new Random().nextInt(this.canvas.getWidth());
            y = 0;
        }else{
            x = 0;
            y = new Random().nextInt(this.canvas.getHeight());
        }
        this.color = color;
    }
    public Ball(Component c, Color color, int _x, int _y){
        this.canvas = c;
        this.id = ++lastId;
        this.x = _x;
        this.y = _y;
        this.color = color;
    }
    public static void f(){
        int a = 0;
    }

    public void draw (Graphics2D g2){
        g2.setColor(this.color);
        g2.fill(new Ellipse2D.Double(x,y,XSIZE,YSIZE));

    }

    public void move(){
        x+=dx;
        y+=dy;
        if(x<0){
            x = 0;
            dx = -dx;
        }
        if(x+XSIZE>=this.canvas.getWidth()){
            x = this.canvas.getWidth()-XSIZE;
            dx = -dx;
        }
        if(y<0){
            y=0;
            dy = -dy;
        }
        if(y+YSIZE>=this.canvas.getHeight()){
            y = this.canvas.getHeight()-YSIZE;
            dy = -dy;
        }
        this.canvas.repaint();
    }
    public void repaintCanvas(){
        this.canvas.repaint();
    }

    public boolean doCirclesIntersectHole(Hole hole) {
        double centerX1 = this.x + this.YSIZE / 2;
        double centerY1 = this.y + this.XSIZE / 2;
        double centerX2 = hole.getX() + hole.getYSIZE() / 2;
        double centerY2 = hole.getY() + hole.getXSIZE() / 2;
        double radius1 = this.YSIZE / 2;
        double radius2 = hole.getYSIZE() / 2;

        double distanceBetweenCenters = Math.sqrt((centerX1 - centerX2) * (centerX1 - centerX2) + (centerY1 - centerY2) * (centerY1 - centerY2));
        return distanceBetweenCenters <= (radius1 + radius2);
    }

}
