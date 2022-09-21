package org.ipan.concurrency.pubcons;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PublisherConsumerExample implements Runnable {

    @Override
    public void run() {
        ArrayBlockingQueue<Work<Double>> queue = new ArrayBlockingQueue<Work<Double>>(5);
        Thread prod = new Thread(() -> {
            Random r = new Random();
            for (int i = 0; i < 6; i++) {
                double a = r.nextDouble(), b = r.nextDouble();
                System.out.format("Item # %s The numbers are %s,  %s \n", i, a, b);
                try {
                    queue.put(new SimpleSumWork(a, b));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread cons = new Thread(() -> {
            Work<Double> work = null;
            try {
                while (true) {
                    work = queue.take();
                    double result = work.work();
                    System.out.format("Result is %s \n", result);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        prod.start();
        cons.start();
    }
}
