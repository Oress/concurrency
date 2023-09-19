package org.ipan.concurrency.visibilityProblem;

public class VisibilityRunnerIntrinsic {
    public static void main(String[] args) throws InterruptedException {
        ThreadReader threadReader = new ThreadReader();
        threadReader.start();

        Thread.sleep(3000);
        threadReader.setValueIntrinsicLock(true);
    }
}
