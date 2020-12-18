package com.example.test.loacl.test.test;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lizongren
 * @create 2020.05.09 18:41
 */

public class PrintRunnable implements Runnable {
    AtomicInteger atomicInteger=new AtomicInteger(0);
    String string;
    int a;
    int b;
    private final int MAX_NUM = 10;
    private final Object lock = new Object();

    public PrintRunnable(AtomicInteger atomicInteger, int a,int b) {
        this.atomicInteger = atomicInteger;
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (lock) {
        while (true) {
            int i1 = atomicInteger.get();
            if (i1>MAX_NUM){
                break;
            }
            if (i1%a==b-1){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            atomicInteger.getAndIncrement();
            int i = atomicInteger.get();
            System.out.println(b+"--" + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.notifyAll();
        }
        }
    }
}
