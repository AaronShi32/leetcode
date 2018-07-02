package skill.juc;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockMain {

    public void example(){
        ReentrantLock lock = new ReentrantLock(true);

        try{
            lock.lock();
            // do .....
            lock.unlock();
        } finally {
            lock.unlock();
        }
    }




    public static void main(String[] args){

    }
}

class SThread implements Runnable {

    private synchronized void get(){
        System.out.println(Thread.currentThread().getName() + " 读取");
        set();
    }

    private synchronized void set(){
        System.out.println(Thread.currentThread().getName() + " 保存");

    }


    @Override
    public void run() {
        get();
    }

    public static void main(String[] args){
        SThread ss = new SThread();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
    }
}

class LThread implements Runnable {

    private ReentrantLock lock = new ReentrantLock();

    public void get(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " 读取");
            set();
        } finally {
            lock.unlock();
        }
    }

    public void set(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " 保存");
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        get();
    }

    public static void main(String[] args){
        LThread ll = new LThread();
        new Thread(ll).start();
        new Thread(ll).start();
        new Thread(ll).start();
    }
}
