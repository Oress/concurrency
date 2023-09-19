package org.ipan.concurrency.privateLock;

public class Runner {
    public static void main(String[] args) {
        PublicLock pubLock = new PublicLock();
        Thread t1 = new Thread(() -> {
            synchronized (pubLock) {
                // Now we cannot do anything within pubLock object
                pubLock.doWork();
            }
        });
        t1.start();
        pubLock.doWork();
    }
}
