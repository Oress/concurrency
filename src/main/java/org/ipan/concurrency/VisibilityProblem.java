package org.ipan.concurrency;

public class VisibilityProblem implements Runnable {
    boolean working = false;

    public void work() {
        while (!working) {

        }
    }

    public void stop() {
        this.working = true;
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
