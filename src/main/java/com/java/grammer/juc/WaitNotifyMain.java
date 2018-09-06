package com.java.grammer.juc;

import java.util.concurrent.Semaphore;

public class WaitNotifyMain {

    private static volatile int i = 0;


    static class A extends Thread {

        private Semaphore s;

        public A(Semaphore s){
            this.s = s;
        }

        public void run(){
            try {
                while(i < 50){
                    s.acquire();
                    System.out.println(Thread.currentThread().getName());
                    i++;
                    s.release();
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally{
                s.release();
            }

        }
    }

    static class B extends Thread {

        private Semaphore s;

        public B(Semaphore s){
            this.s = s;
        }

        public void run(){
            try {
                while(i < 50){
                    s.acquire();
                    System.out.println(Thread.currentThread().getName());
                    i++;
                    s.release();
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally{
                s.release();
            }

        }
    }

    public static void main(String[] args){
        Semaphore s = new Semaphore(1);
        A a = new A(s);
        B b = new B(s);
        // a.start();
        // b.start();
        boolean m = false;
        boolean n = true;
        System.out.println(m == n);
    }
}
