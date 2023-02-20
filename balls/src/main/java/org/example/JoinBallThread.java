package org.example;

public class JoinBallThread extends BallThread {
    private BallThread parentThread;

    public JoinBallThread(Ball ball, BallCanvas canvas, BallThread parentThread) {
        super(ball, canvas);
        this.parentThread = parentThread;
    }
    @Override
    public void run(){
        try{
            parentThread.join();
            super.run();
        }
        catch (InterruptedException e){
            super.interrupt();
        }
    }
}
