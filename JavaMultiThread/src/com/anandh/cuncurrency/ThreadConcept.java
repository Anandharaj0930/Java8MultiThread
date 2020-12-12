package com.anandh.cuncurrency;

public class ThreadConcept {

    public void printAll() {
        for(int i =0; i<=5;i++) {
            System.out.println("i = " + i);
        }
    }
    public static void main(String[] args) {
        ThreadConcept threadConcept = new ThreadConcept();
        System.out.println(" Started the application " );
        for(int i =0; i<=5;i++) {
            System.out.println("First itreation= " + i);
        }
        System.out.println("Second job started" );
        threadConcept.printAll();
        System.out.println("End the application " );
    }

}
