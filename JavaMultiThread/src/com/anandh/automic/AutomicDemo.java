package com.anandh.automic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static com.anandh.CuncurrencyUtil.CuncurrencyUtils.stop;

//Instead of synchronize and locks we can use perform parallel operation on single variable in mutiple threads
//It's faster than sych and lock
public class AutomicDemo {
    public static void main(String[] args) {
       AtomicInteger atomicInt = new AtomicInteger(0);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        IntStream.range(0, 100)
                .forEach(i -> executor.submit(atomicInt::incrementAndGet));
        stop(executor);

        System.out.println(atomicInt.get());    // => 1000
    }

}
