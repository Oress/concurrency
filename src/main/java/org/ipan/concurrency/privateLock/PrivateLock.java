package org.ipan.concurrency.privateLock;

public class PrivateLock {
    private final Object myLock = new Object();

    public void doWork() {
        synchronized (myLock) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
