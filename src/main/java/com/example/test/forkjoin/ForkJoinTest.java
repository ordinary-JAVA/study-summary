package com.example.test.forkjoin;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class ForkJoinTest {


    public static void main(String[] args) {
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        forkJoinPool.execute(new SonTask(0,20));
        forkJoinPool.awaitQuiescence(2, TimeUnit.SECONDS);
        forkJoinPool.shutdown();
    }


    static class SonTask extends RecursiveAction {
        private int uid;
        private int start;
        private int end;
        private static final int size=4;

        public SonTask(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        protected void compute() {
            if (end-start<size){
                for (int i=start;i<end;i++){
                    uid++;
                }
                System.out.println(Thread.currentThread().getName()+"-"+uid);
            }else{
                int middle=(end+start)/2;
                SonTask leftSonTask = new SonTask(start, middle);
                SonTask rightSonTask = new SonTask(middle, end);
                leftSonTask.fork();
                rightSonTask.fork();
            }
        }
    }
}
