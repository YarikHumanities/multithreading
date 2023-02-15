package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BallCanvas extends JPanel {
    public void setBalls(ArrayList<Ball> balls) {
        this.balls = balls;
    }
    public void changeColourByIndex(int i){
        this.balls.get(i).setColor(Color.GREEN);
    }
    private ArrayList<Ball> balls = new ArrayList<>();
    private ArrayList<Hole> holes = new ArrayList<>();
    public ArrayList<Ball> getBalls() {
        return balls;
    }

    public ArrayList<Hole> getHoles() {
        return holes;
    }
    public void add(Ball b){
        this.balls.add(b);
    }
    public void add(Hole hole){
        this.holes.add(hole);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        for(int i=0; i<holes.size();i++){
            Hole b = holes.get(i);
            b.draw(g2);
        }

        for(int i=0; i<balls.size();i++){
            Ball b = balls.get(i);
            b.draw(g2);
        }

    }
}
