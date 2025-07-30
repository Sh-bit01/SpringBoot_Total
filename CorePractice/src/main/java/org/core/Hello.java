package org.core;

public class Hello extends Thread {
    @Override
    public void run() {
        int i = 1;
        while(i < 1000){
            System.out.println("hello");
            System.out.println(currentThread() + "  "+ activeCount());
            i++;
        }

    }
}
