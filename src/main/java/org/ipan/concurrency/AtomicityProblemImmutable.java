package org.ipan.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AtomicityProblemImmutable implements Runnable {
    volatile ValueCache cache = new ValueCache();

    @Override
    public void run() {
        Random r = new Random();
        r.nextInt(10);
        List<Thread> threads = new ArrayList<>(24);
        for (int i = 0; i < 20; i++) {
            int request = r.nextInt();

            Thread t = new Thread(() -> {
                Integer[] result = cache.tryGetFactors(request);
                if (result == null) {
                    // make some calculations here.
                    cache = new ValueCache(request, result);
                }
                // return result
            });
            threads.add(t);
        }
        threads.forEach(Runnable::run);
    }

    class ValueCache {
        private final Integer value;
        private final Integer[] factors;

        public ValueCache() {
            this(null, null);
        }

        public ValueCache(Integer value, Integer[] factors) {
            this.value = value;
            this.factors = factors;
        }

        public Integer[] tryGetFactors(int value) {
            if (this.value != null && value == this.value) {
                return Arrays.copyOf(factors, factors.length);
            }
            return null;
        }
    }
}
