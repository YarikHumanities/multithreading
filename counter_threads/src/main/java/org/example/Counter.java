package org.example;

public class Counter {

    public int counter_value = 0;

    public Counter() {
    }
    public synchronized void  increment(){
        this.counter_value++;
    }
    public synchronized void  decrement(){
        this.counter_value--;
    }
}
