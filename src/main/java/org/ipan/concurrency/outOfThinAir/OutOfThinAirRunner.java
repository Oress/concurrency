package org.ipan.concurrency.outOfThinAir;

import java.util.Random;

// It doesnt work :(
// but in theory the long value may be read partially by the reader thread
public class OutOfThinAirRunner {
    public static void main(String[] args) {
        ReaderThread readerThread = new ReaderThread();
        WriterThread writerThread = new WriterThread(readerThread);
        WriterThread writerThread2 = new WriterThread(readerThread);
        readerThread.start();
        writerThread.start();
        writerThread2.start();
    }
}

