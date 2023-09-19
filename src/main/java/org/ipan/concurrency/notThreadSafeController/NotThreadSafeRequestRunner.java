package org.ipan.concurrency.notThreadSafeController;

import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.util.*;
import java.util.concurrent.*;

public class NotThreadSafeRequestRunner {
    public static void main(String[] args) throws InterruptedException {
        Map<Integer, BigInteger> results = new HashMap<>();
        System.out.format("Number of processors: %d\n", Runtime.getRuntime().availableProcessors());
        ExecutorService executor = Executors.newFixedThreadPool(20);
        Collection<Task> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int num = 10 + i;
            list.add(new Task(num));
        }

        executor.invokeAll(list).forEach(task -> {
            Result result = null;
            try {
                result = task.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
            results.put(result.getNum(), result.getResult());
        });

        results.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry ->
                System.out.printf("Factorial of %d is %d%n", entry.getKey(), entry.getValue()));

    }

    static class Task implements Callable<Result>
    {
        RestTemplate template = new RestTemplate();

        private final Integer num;

        public Task(Integer num) {
            this.num = num;
        }

        @Override
        public Result call() throws Exception
        {
            BigInteger res = template.getForObject(String.format("http://localhost:8080/factorial?factorial=%d", num), BigInteger.class);
            return new Result(num, res);
        }
    }

    static class Result {
        private final Integer num;
        private final BigInteger result;

        public Result(Integer num, BigInteger result) {
            this.num = num;
            this.result = result;
        }

        public Integer getNum() {
            return num;
        }

        public BigInteger getResult() {
            return result;
        }
    }
}
