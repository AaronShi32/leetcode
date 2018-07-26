package com.java.grammer.juc;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁: Spin-Wait
 *
 * 可重入: 当自身线程持有锁的时候可以再次拿到锁, 否则容易引起死锁
 */
public class SpinLock implements Lock {

    private AtomicReference<Thread> owner = new AtomicReference<>(); // 持有自旋锁的线程对象

    private int count; // 用一个计数器 来做 重入锁获取次数的计数

    @Override
    public void lock() {
        Thread cur = Thread.currentThread();
        if(cur == owner.get()){
            count ++;
            return;
        }

        while (!owner.compareAndSet(null, cur)){

        }
    }

    @Override
    public void unlock() {
        Thread cur = Thread.currentThread();
        if(cur == owner.get()){
            if (count > 0){
                count --;
            } else {
               owner.compareAndSet(cur, null);
            }
        }
    }
}
