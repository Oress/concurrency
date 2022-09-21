package org.ipan.concurrency;

public class ThreadInterruptExample implements Runnable {
    @Override
    public void run() {
        Thread t = new Thread(() -> {
            try {
                while (true) {
                    System.out.format("working %s \n", Thread.interrupted());
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        try {
            Thread.sleep(200);
            t.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
