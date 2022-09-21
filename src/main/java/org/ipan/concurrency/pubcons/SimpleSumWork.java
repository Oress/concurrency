package org.ipan.concurrency.pubcons;

public class SimpleSumWork implements Work<Double> {
    private final double a;
    private final double b;

    public SimpleSumWork(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Double work() {
        return a+b;
    }
}
