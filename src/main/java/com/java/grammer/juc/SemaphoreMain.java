package com.java.grammer.juc;

import java.util.concurrent.Semaphore;

/**
 * 信号量
 * Semaphore A = new Semaphore(1);
 * a.acquire();
 * a.release();
 */
public class SemaphoreMain {

    private static Semaphore A = new Semaphore(1);
    private static Semaphore B = new Semaphore(1);
    private static Semaphore C = new Semaphore(1);


    static class AThread extends Thread {

        public void run(){
            try {
                for(int i = 0; i < 10; i++){
                    A.acquire();
                    System.out.println("AThread is running");
                    B.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    static class BThread extends Thread {

        public void run(){
            try {
                for(int i = 0; i < 10; i++) {
                    B.acquire();
                    System.out.println("BThread is running");
                    C.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class CThread extends Thread {

        public void run(){
            try {
                for(int i = 0; i < 10; i++) {
                    C.acquire();
                    System.out.println("Thread is running");
                    A.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        B.acquire();
        C.acquire();
        AThread a = new AThread();
        BThread b = new BThread();
        CThread c = new CThread();
        a.start();
        b.start();
        c.start();
    }

}
