package org.example;

import java.awt.*;

public class BallThread extends Thread {
    static public int getInHoleCounter = 0;
    private Ball b;
    private BallCanvas currentCanvas;

    public BallThread(Ball ball, BallCanvas canvas){
        b = ball;
        this.currentCanvas = canvas;
    }
    public boolean getInHoleHandler(){
        return false;
    }
    @Override
    public void run(){
        try{
            for(int i=1; i<10000; i++){
                b.move();
                for(int j=0; j<this.currentCanvas.getHoles().size(); j++){

                    if(b.doCirclesIntersectHole(this.currentCanvas.getHoles().get(j))){

                        this.currentCanvas.getBalls().removeIf(ball -> ball.getId() == this.b.getId());
                        ++getInHoleCounter;
                        b.repaintCanvas();
                        b.setColor(Color.GREEN);
                        System.out.println(Thread.currentThread().getName() + " ball turned GREEN");
                        System.out.println("Balls in Holes: " + this.getInHoleCounter);
                        BounceFrame.setBallsInHoles(BallThread.getInHoleCounter);

                        return;
                    }
                }
                System.out.println("Thread name (from BallThread Class) ( = "
                        + this.getPriority() + ") "+ Thread.currentThread().getName());

                Thread.sleep(5);
            }
        } catch(InterruptedException ex){

        }
    }
}
