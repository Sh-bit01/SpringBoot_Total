package org.core;

public class World extends Thread{
    @Override
    public void run() {
        int i = 1;
        while(i < 1000){
            System.out.println("World");
            System.out.println(currentThread() + "  "+ activeCount());
            i++;
        }

    }

}
