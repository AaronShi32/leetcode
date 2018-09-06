package com.java.grammer.juc;

/**
 * 两个线程交替输出: volatile
 */
public class ThreadPrintDemo {

    private static volatile boolean flag = false;

    public static void main(String[] args){
        Thread A = new Thread(()->{
            while(true){
                if(!flag){
                    System.out.println(Thread.currentThread().getName());
                    flag = true;
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread B = new Thread(()->{
            while(true){
                if(flag){
                    System.out.println(Thread.currentThread().getName());
                    flag = false;
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        A.start();
        B.start();
    }
}
