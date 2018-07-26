package com.topic.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadFactory {

    private static void buildThread(){
        int TIME = 5;
        Runnable task = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < TIME; i++){
                    System.out.print(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread ex = new Thread(task);
        ex.setName("使用 Thread 创建线程");
        ex.setUncaughtExceptionHandler((t, e) -> System.out.println(t.getName() + " throw " + e.getMessage()));
        ex.start();


    }

    private static void buildRunnable(){
        int TIME = 10;
        Runnable task = () -> {
            for(int i = 0; i < TIME; i++){
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        task.run();
    }

    private static void buildCallable(){
        int TIME = 6;
        Callable<String> task = () -> {
            for(int i = 0; i < TIME; i++){
                System.out.println(i + "");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "callable done";
        };
        try {
            ExecutorService e = Executors.newFixedThreadPool(3);
            Future future = e.submit(task);
            String result = (String)future.get();
            System.out.println(result);
            System.out.println("done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args){
        //buildThread();
        //buildRunnable();
        buildCallable();
    }
}
