package com.java.grammer.juc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CountDownLatchMain2 {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    static class Task implements Runnable{

        private CountDownLatch latch;

        public Task(CountDownLatch latch){
            this.latch = latch;
        }

        @Override
        public void run() {
            try{
                System.out.println(Thread.currentThread().getName() + " begin at " + sdf.format(new Date()));
                work();
                System.out.println(Thread.currentThread().getName() + " end at " + sdf.format(new Date()));
            } finally {
                this.latch.countDown();
            }
        }

        private void work(){
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args){

        final CountDownLatch latch = new CountDownLatch(10);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
        for(int i = 0; i < 10; i++){
            Task t = new Task(latch);
            executor.execute(t);
        }
        try {
            System.out.println("等待10个子线程执行完毕...");
            latch.await();
            System.out.println("10个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        }catch(Exception e){
            e.printStackTrace();
        }
        executor.shutdown();
    }

}
