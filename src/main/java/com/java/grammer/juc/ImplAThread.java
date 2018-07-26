package com.java.grammer.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现线程的三种方式
 */
public class ImplAThread {

    public static void ImplThread(){
        AThread t = new AThread();
        t.start();
    }

    public static void ImplRunnable(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 实现 Runnable 接口实现线程...");
            }
        });

        t.start();
    }

    public static void ImplCallable() throws ExecutionException, InterruptedException {
        //FutureTask 可用于 闭锁 类似于CountDownLatch的作用，在所有的线程没有执行完成之后这里是不会执行的
        FutureTask<Integer> result = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() {
                System.out.println(Thread.currentThread().getName() + " 实现 Callable 接口实现线程...");
                return 1;
            }
        });
        Thread t = new Thread(result);
        t.start();
        System.out.println(result.get());
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ImplThread();
        ImplRunnable();
        ImplCallable();

    }

}

class AThread extends Thread{

    private String desc;

    public AThread(){
        this.desc = "继承 Thread 实现线程...";
    }

    public void run(){
        System.out.println(Thread.currentThread().getName() + " " + this.desc);
    }

}
