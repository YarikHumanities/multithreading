package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

import static java.lang.Thread.MAX_PRIORITY;
import static java.lang.Thread.MIN_PRIORITY;

public class BounceFrame extends JFrame {
    private BallCanvas canvas;
    //private HoleCanvas holeCanvas;
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;
    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce programm");
        this.canvas = new BallCanvas();


        System.out.println("In Frame Thread name = "
                + Thread.currentThread().getName());

        Container content = this.getContentPane();

        content.setLayout(new BorderLayout());
        content.add(this.canvas, BorderLayout.CENTER);

//        Hole hole1 = new Hole(canvas, 100, 100);
//        this.canvas.add(hole1);
////        holeCanvas.add(hole1);
////
////        content.add(this.holeCanvas, BorderLayout.CENTER);
////        content.add(this.canvas, BorderLayout.CENTER);
//        JPanel parent = new JPanel(null);
////        parent.setPreferredSize(content.getSize());
////        parent.setMaximumSize(parent.getPreferredSize());
//
//        this.canvas = new BallCanvas();
//        //canvas.setPreferredSize(parent.getSize());
//        //canvas.setMaximumSize(canvas.getPreferredSize());
//        canvas.setBackground(Color.RED);
//        //canvas.setBounds(50, 50, 200, 200);
//
//        this.holeCanvas = new HoleCanvas();
//        //holeCanvas.setPreferredSize(parent.getSize());
//        //holeCanvas.setMaximumSize(holeCanvas.getPreferredSize());
//        holeCanvas.setBackground(Color.BLUE);
//        //holeCanvas.setBounds(100, 100, 100, 100);
//
//        parent.add(canvas);
//        parent.add(holeCanvas);
//
//
//        content.add(parent);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);
        JButton buttonStart = new JButton("Add1");
        JButton buttonOneRed = new JButton("Add1(r)");
        JButton buttonOneBlue = new JButton("Add1(b)");
        JButton buttonManyBlue = new JButton("AddN(b)");
        JButton buttonManyBlueOneRed = new JButton("AddN&1(b&r)");
        JButton buttonStop = new JButton("Stop");


//        Timer timer = new Timer(16, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                for(int i = 0; i<canvas.getBalls().size(); i++){
//
//                    for(int j = 0; j<canvas.getHoles().size(); j++){
//
//                        if(canvas.getBalls().get(i).doCirclesIntersectHole(canvas.getHoles().get(j))){
//
//                            System.out.println("Thread name in Hole = " + Thread.currentThread().getName());
//                            System.out.println("Ball " + i + " in the hole");
//                            canvas.getBalls().get(i).setColor(Color.GREEN);
//                            //canvas.getBalls().remove(i);
//                        }
//                    }
//                }
//
//            }
//        });
//        timer.start();

        buttonStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Ball b = new Ball(canvas);
                canvas.add(b);

                BallThread thread = new BallThread(b, canvas);
                thread.start();
                System.out.println("Thread name = " +
                        thread.getName());
            }
        });
        buttonOneRed.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Ball b = new Ball(canvas, Color.RED, 100, 100);
                canvas.add(b);

                BallThread thread = new BallThread(b, canvas);
                thread.setPriority(MAX_PRIORITY);
                thread.start();
                System.out.println("Thread name = " +
                        thread.getName());
            }
        });
        buttonOneBlue.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Ball b = new Ball(canvas, Color.BLUE, 100, 100);
                canvas.add(b);

                BallThread thread = new BallThread(b, canvas);
                thread.setPriority(MIN_PRIORITY);
                thread.start();
                System.out.println("Thread name = " +
                        thread.getName());
            }
        });
        buttonManyBlue.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Thread> threads = new ArrayList<Thread>();

                for(int i = 0; i<400; i++) {
                    Ball b = new Ball(canvas, Color.BLUE, 100, 100);
                    canvas.add(b);

                    BallThread thread = new BallThread(b, canvas);
                    thread.setPriority(MIN_PRIORITY);
                    threads.add(thread);
                    //thread.start();
                    System.out.println("Thread name = " +
                            thread.getName());
                }

                for(int i=0; i<threads.size(); i++){
                    threads.get(i).start();
                }
            }
        });
        buttonManyBlueOneRed.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Thread> threads = new ArrayList<Thread>();

                for(int i = 0; i<50; i++) {
                    Ball b = new Ball(canvas, Color.BLUE, 100, 100);
                    canvas.add(b);

                    BallThread thread = new BallThread(b, canvas);
                    thread.setPriority(MIN_PRIORITY);
                    threads.add(thread);

                    System.out.println("Thread name = " +
                            thread.getName());
                }

                for(int i=0; i<1; i++) {
                    Ball b = new Ball(canvas, Color.RED, 100, 100);
                    canvas.add(b);

                    BallThread thread_red = new BallThread(b, canvas);
                    thread_red.setPriority(MAX_PRIORITY);
                    threads.add(thread_red);

                    System.out.println("Thread name = " +
                            thread_red.getName());
                }

                for(int i=0; i<threads.size(); i++){
                    threads.get(i).start();
                }
            }
        });
        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStop);
        buttonPanel.add(buttonOneRed);
        buttonPanel.add(buttonOneBlue);
        buttonPanel.add(buttonManyBlue);
        buttonPanel.add(buttonManyBlueOneRed);
        content.add(buttonPanel, BorderLayout.SOUTH);
    }
}
