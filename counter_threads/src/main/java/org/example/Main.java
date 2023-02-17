package org.example;

public class Main {
    public static void main(String[] args) {

        Counter counter = new Counter();
        System.out.println("Starting Counter Value: " + counter.counter_value);
        CounterThread thread_1 = new CounterThread(counter, true);
        CounterThread thread_2 = new CounterThread(counter, false);
        thread_1.start();
        thread_2.start();
    }
}