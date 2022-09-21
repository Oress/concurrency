package org.ipan.concurrency;

import java.util.ArrayList;
import java.util.List;

// This is due to the fact that list keeps track of modification count
// It's used for early problem detection (fail fast).

public class ListConcurrentModificationExample implements Runnable{
    @Override
    public void run() {
        int n = 10000;
        List<Integer> ints = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            ints.add(i);
        }
        Thread a = new Thread(() -> {
            ints.add(5);
        });
        a.start();
        // the compiler replaces 'foreach' with iterator
        for (Integer anInt : ints) {
            System.out.println(anInt);
        }
    }
}
