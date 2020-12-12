package com.anandh.cuncurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RunnableConcept {

    public static void main(String[] args) {
        System.out.println("Thread Initail Count = " + Thread.activeCount());
        System.out.println("Available Thread " + Runtime.getRuntime().availableProcessors());
        System.out.println("Max Memory " + Runtime.getRuntime().maxMemory());
        System.out.println("Total Memory " + Runtime.getRuntime().totalMemory());
        for (int i = 0; i <= 2; i++) {
            Thread t = new Thread(() -> {
                System.out.println("ThreadName " + Thread.currentThread().getName());
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Download " + Thread.currentThread().getName());
            });
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t.getName() = " + t.getName());
        }
    }

}
