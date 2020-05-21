package com.example.test.test;

import java.util.concurrent.Semaphore;

/**
 * @author lizongren
 * @create 2020.05.09 20:00
 */

public class T3 {
    static int result = 0;
    public static void main(String[] args) throws InterruptedException {
        int N = 3;
        Thread[] threads = new Thread[N];
        final Semaphore[] syncObjects = new Semaphore[N];
        for (int i = 0; i < N; i++) {
            syncObjects[i] = new Semaphore(1);
            if (i != N-1){
                syncObjects[i].acquire();
            }
        }
        //syncObjects[2]未执行.acquire()方法

        //lastSemphore curSemphore  index
        //  2  0  0
        //  0  1  1
        //  1  2  2
        for (int i = 0; i < N; i++) {
            final Semaphore lastSemphore = i == 2 ? syncObjects[0] : syncObjects[i + 1];
            final Semaphore curSemphore = syncObjects[i];
            final int index = i;
            new Thread(new Runnable() {

                public void run() {
                    try {
                        while (true) {
                            lastSemphore.acquire();
                            System.out.println("thread" + index + ": " + result++);
                            if (result > 100){
                                System.exit(0);
                            }
                            curSemphore.release();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }).start();
            //threads[i].start();
        }
    }
}
