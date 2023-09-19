package org.ipan.concurrency.threadlocals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadLocalRunner {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(6);

        // Some of the threads will get the same value, because the thread pool is small
        for (int i = 0; i < 12; i++) {
            executorService.submit(new ThreadLocalRunnable());
        }

        executorService.shutdown();
    }
}
