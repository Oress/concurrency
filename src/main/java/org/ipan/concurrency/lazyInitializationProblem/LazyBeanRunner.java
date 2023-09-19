package org.ipan.concurrency.lazyInitializationProblem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LazyBeanRunner {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                LazyBean lazyBean = LazyBean.getInstance();
            });
        }
    }
}
