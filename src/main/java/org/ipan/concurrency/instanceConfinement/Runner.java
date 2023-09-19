package org.ipan.concurrency.instanceConfinement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        // list collection itself is not thread safe
        List<Integer> list = new ArrayList<>();
        // so if we would like to use it in a multi-threaded environment
        // we may get unpredictable results

        // we can use instance confinement to make it thread safe
        // synchronizedList just provides a synchronized wrapper around the list methods
        List<Integer> confinedList = Collections.synchronizedList(list);
    }
}
