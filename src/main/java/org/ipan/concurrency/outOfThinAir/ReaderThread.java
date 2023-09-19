package org.ipan.concurrency.outOfThinAir;

public class ReaderThread extends Thread {
    private long value;

    @Override
    public void run() {
        while (true) {
            try {
                System.out.printf("Current value: %s \n\n", value);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setValue(long value) {
        this.value = value;
    }
}
