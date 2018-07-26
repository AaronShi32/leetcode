package com.java.grammer.juc;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * 通过中断实现取消
 */
public class InterrputThread extends Thread {

    private final BlockingQueue<BigInteger> queue;

    public InterrputThread(BlockingQueue<BigInteger> queue){
        this.queue = queue;
    }

    public void run(){
        try{
            BigInteger p = BigInteger.ONE;
            while(!Thread.currentThread().isInterrupted()){
                queue.put(p = p.nextProbablePrime());
            }
        }catch (InterruptedException consumed){
            /* 允许线程退出 */
        }
    }

    public void cancel(){
        interrupt();
    }

}
