package org.ipan.concurrency;

public class VisibilityProblemSynchronized implements Runnable {
    volatile boolean working = false;

    public synchronized boolean isWorking() {
        return working;
    }

    public synchronized void setWorking(boolean working) {
        this.working = working;
    }

    public void work() {
        while (!isWorking()) {

        }
    }

    public void stop() {
        this.setWorking(true);
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
