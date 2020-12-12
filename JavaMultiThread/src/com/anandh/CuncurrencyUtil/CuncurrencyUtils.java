package com.anandh.CuncurrencyUtil;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CuncurrencyUtils {

    public static void sleep(long timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
           throw new IllegalStateException();
        }
    }

    public static void stop( ExecutorService executorService) {

        try {
            executorService.shutdown();
            executorService.awaitTermination(60,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("termination interrupted");
        }finally {
            if(!executorService.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executorService.shutdownNow();
        }


    }
}
