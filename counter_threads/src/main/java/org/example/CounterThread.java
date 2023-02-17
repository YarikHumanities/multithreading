package org.example;

public class CounterThread extends Thread {
    private Counter counter;
    private Boolean choise;

    public CounterThread(Counter counter,Boolean choise) {
        this.counter = counter;
        this.choise = choise;
    }

    @Override
    public void run(){
        for(int i = 0; i<50; i++){
            if(this.choise){
                System.out.print("Value before (++) = " + this.counter.counter_value + " / ");
                this.counter.increment();
                System.out.println("Value after (++) = " + this.counter.counter_value);
            }
            else{
                System.out.print("Value before (--) = " + this.counter.counter_value + " / ");
                this.counter.decrement();
                System.out.println("Value after (--) = " + this.counter.counter_value);
            }
        }
    }
}
