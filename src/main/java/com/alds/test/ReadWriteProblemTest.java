package com.alds.test;

import com.alds.concurrency.ReadWriteProblem;

public class ReadWriteProblemTest {
    
    public static void main(String[] args) {    
        ReadWriteProblem ins = new ReadWriteProblem();
        Runnable reader1 = () -> {
            Thread.currentThread().setName("Reader-1");
            try {
                ins.read();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable reader2 = () -> {
            Thread.currentThread().setName("Reader-2");
            try {
                ins.read();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable reader3 = () -> {
            Thread.currentThread().setName("Reader-3");
            try {
                ins.read();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable writer = () -> {
            Thread.currentThread().setName("Writer");
            try {
                ins.write("Test2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable reader4 = () -> {
            Thread.currentThread().setName("Reader-4");
            try {
                ins.read();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        
        new Thread(reader1).start();
        new Thread(reader2).start();
        new Thread(writer).start();
        new Thread(reader3).start();
        new Thread(reader4).start();
    }

}
