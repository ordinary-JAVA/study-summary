package com.example.test.test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lizongren
 * @create 2020.05.22 10:59
 */

public class TRunnable  implements Runnable{
    Object lock=new Object();
    AtomicInteger a;
    Semaphore semaphore;
    public TRunnable(int a,Semaphore semaphore) {
        this.a = new AtomicInteger(a);
        this.semaphore=semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock){
            System.out.println(a);
        }
        semaphore.release();
    }

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore=new Semaphore(1);
        for (int a=0;;a++){
            if (a>1000){
                break;
            }

           new Thread(new TRunnable(a,semaphore)).start(); ;
        }
    }
}
