package org.ipan.concurrency;

import java.util.Random;

public class ThreadLocalExample implements Runnable {

    private static ThreadLocal<Integer> randomNumber = ThreadLocal.withInitial(() -> new Random().nextInt());

    @Override
    public void run() {
        Thread t1 = new Thread(()-> {
            System.out.format("Greetings from thread %s, my number is: %s \n", Thread.currentThread().getName(), randomNumber.get());
        });
        Thread t2 = new Thread(()-> {
            System.out.format("Greetings from thread %s, my number is: %s \n", Thread.currentThread().getName(), randomNumber.get());
        });
        Thread t3 = new Thread(()-> {
            System.out.format("Greetings from thread %s, my number is: %s \n", Thread.currentThread().getName(), randomNumber.get());
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
