package org.ipan.concurrency.lazyInitializationProblem;

// This class is not thread safe because it is not synchronized.
// the getInstance() method can be called by multiple threads at the same time, thus creating multiple instances of the class.
public class LazyBean {
    private static LazyBean instance;

    private LazyBean() {}

    public static LazyBean getInstance() {
        if (instance == null) {
            instance = new LazyBean();
            System.out.println("LazyBean instance created");
        }
        return instance;
    }
}
