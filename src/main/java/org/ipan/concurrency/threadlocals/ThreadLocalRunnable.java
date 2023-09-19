package org.ipan.concurrency.threadlocals;

import java.util.Random;

public class ThreadLocalRunnable implements Runnable {
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private static Random r = new Random();

    @Override
    public void run() {
        String s = threadLocal.get();
        String name = Thread.currentThread().getName();
        if (s != null) {
            System.out.format("Thread Local %s has value %s \n", name, s);
        } else {
            threadLocal.set(String.valueOf(r.nextLong()));
            System.out.format("Thread Local %s has initialized with %s \n", name, threadLocal.get());
        }
    }
}
