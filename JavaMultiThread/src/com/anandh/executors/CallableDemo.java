package com.anandh.executors;

import java.util.concurrent.*;

//Executors providing callable functionality.It will like a Runnable but it will return value .
//Callable is functional interface . When you submit will return value before service completion
//Since submit() doesn't wait until the task completes,
// the executor service cannot return the result of the callable directly.
// Instead the executor returns a special result of type
// Future which can be used to retrieve the actual result at a later point in time.
public class CallableDemo {

    public static void main(String[] args) {
        Callable<Integer> task = () -> {
            try {
                System.out.println("Callable statement");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                throw new IllegalStateException("task interrupted", ex);
            }

            return 125;
        };
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService.submit(task);

        try {
            System.out.println("future done? " + future.isDone());
            Integer value = null;
            try {
                value = future.get(2, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            System.out.println("future done? " + future.isDone());
            System.out.println("result: " + value);
            System.out.println("shoutdown check :" + executorService.isShutdown());
            executorService.shutdown();
            System.out.println("shoutdown check :" + executorService.isShutdown());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
