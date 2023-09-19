package org.ipan.concurrency.visibilityProblem;

public class ThreadReader extends Thread {
    private boolean value;
    private int number;

    @Override
    public void run() {
        while (!value) {
//            System.out.println("Looping");
        }
        System.out.printf("Number, %s \n", number);
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public synchronized void setValueIntrinsicLock(boolean value) {
        this.value = value;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
