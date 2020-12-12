package com.anandh.cuncurrency;

public class ThreadConcept {
    public static void main(String[] args) {
        new MyThread("My1");
        new MyThread("My2");
    }
}
class MyThread extends Thread {

    String threadName;
    Thread t;
    MyThread (String name) {

        threadName = name;
        t = new Thread(this,name);
        System.out.println("new thread : = " + t.getName());
        t.start();
    }
    @Override
    public void run() {
for (int i =1;i<=3;i++) {
    try {
        t.sleep(600);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("i :"+i);
}
    }
}
