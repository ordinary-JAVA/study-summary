package com.example.test.loacl.test.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lizongren
 * @create 2020.05.09 18:41
 */

public class T2 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger();

        PrintRunnable printRunnable1=new PrintRunnable(atomicInteger,2,2);
       PrintRunnable printRunnable=new PrintRunnable(atomicInteger,2,1);
        new Thread(printRunnable1).start();
        new Thread(printRunnable).start();



    }
}
