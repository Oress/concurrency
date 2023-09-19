package org.ipan.concurrency.privateLock;

public class PublicLock {

    // synchronized keyword means that we synchronize on this object
    public synchronized void doWork() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
