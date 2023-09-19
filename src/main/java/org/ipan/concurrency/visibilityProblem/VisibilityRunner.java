package org.ipan.concurrency.visibilityProblem;

import org.ipan.concurrency.VisibilityProblem;

// The number of invocation greatly affects the chance of caching the variable.
// The simple System.out.println("Looping"); may greatly decrease the number of invocations of that variable, thus we might not get cached variable.
public class VisibilityRunner {
    public static void main(String[] args) throws InterruptedException {
        ThreadReader threadReader = new ThreadReader();
        threadReader.start();

        Thread.sleep(3000);
        threadReader.setValue(true);
        threadReader.setNumber(55);
    }
}
