package org.ipan.concurrency;

import java.util.concurrent.atomic.AtomicBoolean;

public class VisibilityProblemAtomic implements Runnable {
    volatile AtomicBoolean working = new AtomicBoolean();

    public void work() {
        while (!working.get()) {

        }
    }

    public void stop() {
        this.working.set(true);
    }

    @Override
    public void run() {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                stop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        work();
    }
}
