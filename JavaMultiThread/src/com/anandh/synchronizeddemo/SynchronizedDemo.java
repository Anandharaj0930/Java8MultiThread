package com.anandh.synchronizeddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SynchronizedDemo {
    Integer count = 0;

    synchronized void increment() {
        count = count + 1;
    }

    Integer countNonThread = 0;

    void incrementNonThread() {
        countNonThread = countNonThread + 1;
    }


    //Result will differ
    public void demoSych() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        IntStream.range(0, 100).forEach(i -> executorService.submit(this::increment));

        executorService.shutdown();

        System.out.println(count);
    }

    //Always return 999 because single thread involved
    public void nonThead() {
        IntStream.range(1, 100).forEach(i -> incrementNonThread());
        System.out.println(countNonThread);
    }

    public static void main(String[] args) {
        SynchronizedDemo s = new SynchronizedDemo();
        s.demoSych();
        s.nonThead();
    }
}
