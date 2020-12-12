package com.anandh.synchronizeddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import static com.anandh.CuncurrencyUtil.CuncurrencyUtils.sleep;
import static com.anandh.CuncurrencyUtil.CuncurrencyUtils.stop;

//Lock is used to avoid multiple thread access the same process at a time .
// Once it's locked it will not allow to access by other thread
public class LockDemo {
    ReentrantLock lock = new ReentrantLock();
    int count = 0;

    void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public void reentLockDemo() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ReentrantLock lock = new ReentrantLock();
        executorService.submit(() -> {
            lock.lock();
            try {
                System.out.println("Held by first: " + lock.isHeldByCurrentThread());
                sleep(2);
            } finally {
                lock.unlock();
            }
        });
        executorService.submit(() -> {
            System.out.println("Locked: " + lock.isLocked());
            System.out.println("Held by me: " + lock.isHeldByCurrentThread());
            boolean locked = lock.tryLock();
            System.out.println("Lock acquired: " + locked);
            stop(executorService);
        });

    }

    public static void main(String[] args) {
        LockDemo lockDemo = new LockDemo();
        lockDemo.reentLockDemo();
    }
}
