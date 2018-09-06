package com.java.grammer.juc;

public class ThreadPrintDemo2 {

    private final static Object lock = new Object();
    private static boolean flag = true;

    public static void main(String[] args) {
        Thread A = new Thread(() -> {
            while(true) {
                synchronized (lock) {
                    try {
                        if (flag) {
                            lock.wait();
                        }
                        System.out.println(Thread.currentThread().getName());
                        flag = true;
                        lock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        Thread B = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    try {
                        if (!flag) {
                            lock.wait();
                        }
                        System.out.println(Thread.currentThread().getName());
                        flag = false;
                        lock.notify();
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
