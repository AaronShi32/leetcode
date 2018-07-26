package com.topic.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Shop {


    private static void blockingQueue(){
        BlockingQueue box = new LinkedBlockingQueue(10);

        Thread cq = new Thread(new CustomQueue(box));

        Thread cp = new Thread(new ProduceQueue(box));

        cq.start();

        cp.start();
    }

    private static void waitNotify(){
        Product candy = new Product();

        Thread c = new Thread(new Customer(candy));

        Thread p = new Thread(new Producer(candy));

        p.start();

        c.start();
    }

    public static void main(String[] args){

        blockingQueue();
        waitNotify();
    }
}
