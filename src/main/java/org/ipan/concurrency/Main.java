package org.ipan.concurrency;

import org.ipan.concurrency.pubcons.PublisherConsumerExample;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {
//        VisibilityProblem vp = new VisibilityProblem();
//        VisibilityProblemVolatile vp = new VisibilityProblemVolatile();
//        VisibilityProblemAtomic vp = new VisibilityProblemAtomic();
//        VisibilityProblemSynchronized vp = new VisibilityProblemSynchronized();

//        ThreadLocalExample tle = new ThreadLocalExample();
//        tle.run();

//        Vector<Integer> v = new Vector<>();
//        v.add()

//        ListConcurrentModificationExample ex = new ListConcurrentModificationExample();
//        ex.run();

//        PublisherConsumerExample ex = new PublisherConsumerExample();
//        ex.run();

//        ThreadInterruptExample ex = new ThreadInterruptExample();
//        ex.run();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
//        scheduledExecutorService.schedule();
    }

    private static void visibility() {
        VisibilityProblem pro = new VisibilityProblem();

        AtomicLong al = new AtomicLong(0);
        al.incrementAndGet();
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000);
                pro.stop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();

        System.out.println("Start Working");
        pro.work();
        System.out.println("Stop Working");
    }
}


