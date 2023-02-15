package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HoleCanvas extends JPanel {
    private ArrayList<Hole> holes = new ArrayList<>();

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
    }
}
