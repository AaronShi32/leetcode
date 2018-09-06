package com.java.grammer.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

public interface JUCLock {

    void lock();

    void unlock();

    void lockInterruptibly() throws InterruptedException;

    boolean tryLock();

    boolean tryLock(long time, TimeUnit unit) throws InterruptedException;

    Condition newCondition();

}
