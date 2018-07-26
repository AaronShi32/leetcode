package com.java.grammer.juc;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁
 *
 * 调用 await 的线程会被中断, 直到 countDown 为 0 时重新唤醒
 */
public class LatchMain {

    public static void main(String[] args) throws InterruptedException {

        int count = 10;

        CountDownLatch startState = new CountDownLatch(1);
        CountDownLatch endState = new CountDownLatch(count);

        for(int i = 0; i < count; i++){
            Thread task = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        startState.await();
                        work();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        endState.countDown();
                        System.out.println(Thread.currentThread().getName() + " work done.");
                    }
                }

                private void work(){
                    System.out.println(Thread.currentThread().getName() + " is working.");
                }
            });

            task.start();
        }

        long start = System.nanoTime();

        startState.countDown();

        endState.await();

        long end = System.nanoTime();

        System.out.println("cost: " + (end - start));

    }
}
