package com.java.grammer.juc;

import java.util.concurrent.*;

public class ExecutorMain {

    private int NTHREAD = 50;

    private Executor exec1 = Executors.newFixedThreadPool(NTHREAD);

    private Executor exec2 = Executors.newCachedThreadPool();

    private Executor exec3 = Executors.newScheduledThreadPool(NTHREAD);

    private Executor exec4 = Executors.newSingleThreadExecutor();

    private Executor exec5 = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args){

        /**
         * Executors is a Factory Class of ThreadPoolExecutor, avoid to use it in product ENVIRONMENT;
         *
         * ThreadPoolExecutor extends AbstractExecutorService 可以管理生命周期
         *
         * public ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue)
         */
    }
}
