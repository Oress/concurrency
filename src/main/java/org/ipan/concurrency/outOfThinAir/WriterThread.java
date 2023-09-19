package org.ipan.concurrency.outOfThinAir;

import java.util.Random;

public class WriterThread extends Thread {
    ReaderThread readerThread;

    public WriterThread(ReaderThread readerThread) {
        super();
        this.readerThread = readerThread;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Long value = new Random().nextLong();
                System.out.printf("Writing value: %s \n", value);
                readerThread.setValue(value);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
