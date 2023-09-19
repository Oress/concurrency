package org.ipan.concurrency.futures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class SimpleFutureRunner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        Future<String> result = executorService.submit(() -> {
            URL url = new URL("http://www.google.com");
            return new BufferedReader(new InputStreamReader(url.openStream())).lines().collect(Collectors.joining("\n"));
        });

        while (!result.isDone()) {
            System.out.println("Waiting for result...");
            Thread.sleep(300);
        }

        System.out.println(result.get());

        executorService.shutdown();
    }
}
