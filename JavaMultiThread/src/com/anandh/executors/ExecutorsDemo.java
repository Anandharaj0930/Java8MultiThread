package com.anandh.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//Executors is Concurrency API provided by JAVA used to run asychronous tasks.typically manage the thread pool.
//No need to create thread manually
public class ExecutorsDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i =0;i<=2;i++) {
            executorService.submit(() ->{
                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            });
        }

        try {
            System.out.println("Attempt to shutdown executor");
            //It will waits for currently running tasks to finish
            executorService.shutdown();
            //waiting the task to complete 5 min , if exceed need to terminate and close
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executorService.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            //It will interrupts all running tasks and shut the executor down immediately.
            executorService.shutdownNow();
            System.out.println("shutdown finished");
        }
    }
}
