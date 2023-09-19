package org.ipan.concurrency.executors;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class SimpleExecutorRunner {
    public static void main(String[] args) throws InterruptedException {
//        List<Future<BigInteger>> futures = new ArrayList<>();

        ExecutorService exec = Executors.newFixedThreadPool(10);
        CompletionService<BigInteger> completionService = new ExecutorCompletionService<>(exec);
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            Future<BigInteger> result = completionService.submit(() -> {
                BigInteger int1 = BigInteger.valueOf(r.nextLong(1000000000, 1001000000));
                int exponent = r.nextInt(9000, 10000);
                BigInteger pow = int1.pow(exponent);
                System.out.printf("int1: %s, exp: %s, pow: %s\n", int1, exponent, pow);
                return pow;
            });
//            futures.add(result);
        }

        for (int i = 0; i < 100; i++) {
            completionService.take();
        }

        exec.shutdown();
    }
}
