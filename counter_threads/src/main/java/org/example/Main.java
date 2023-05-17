package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();
        System.out.println("Starting Counter Value: " + counter.counter_value);
        CounterThread thread_1 = new CounterThread(counter, true);
        CounterThread thread_2 = new CounterThread(counter, false);

        thread_1.start();
        thread_2.start();

        thread_1.join();
        thread_2.join();

        System.out.println(counter.counter_value);
    }
}


