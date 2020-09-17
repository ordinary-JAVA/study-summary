package com.example.test.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RuntimeConstantPoolOOM {
    public static void main(String[] args) throws InterruptedException {

    while (true){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                while (true){}
            }
        });
        thread.start();
    }

    }

    public static void runtimeConstantPoolOOM() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(Integer.MAX_VALUE);
        for (int i=0;;i++){
            if (i>10){
                Thread.sleep(2000L);
            }
            List<String> list=new ArrayList<>();
            executorService.execute(()->{
                Long i1=0L;
                while (true){
                    System.out.println(Thread.currentThread().getName()+"-"+i1);
                    list.add(String.valueOf(i1++).intern());
                }
            });
        }
    }
}
