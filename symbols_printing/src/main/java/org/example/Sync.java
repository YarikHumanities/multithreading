package org.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Sync {
    private boolean permission;
    private int num;
    private boolean stop;

    public Sync(){
        permission = true;
        num = 0;
        stop = false;
    }
    public synchronized boolean getPermission(){
        return this.permission;
    }
    public synchronized boolean isStop(){
        return this.stop;
    }
    public synchronized void changePermission(){
        permission = !permission;
        num++;
        if(num%100==0){
            System.out.println();
        }
        if(num==10000){
            stop=true;
        }
    }
    public synchronized void waitAndChange(boolean control, String s){
        while(getPermission()!=control){
            try{
                wait();
            } catch (InterruptedException ex){
                Logger.getLogger(Sync.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(stop){
            notifyAll();
            return;
        }
        System.out.print(s);
        permission = !permission;
        num++;
        if(num%100==0){
            System.out.println();
        }
        if(num==100000){
            stop=true;
        }
        notifyAll();
    }
}
