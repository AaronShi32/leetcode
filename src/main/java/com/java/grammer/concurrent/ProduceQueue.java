package com.topic.concurrent;

import java.util.concurrent.BlockingQueue;

public class ProduceQueue implements Runnable{

    private BlockingQueue box;
    private final static int TIME = 20;

    public ProduceQueue(BlockingQueue box) {
        this.box = box;
    }

    @Override
    public void run() {
        for(int i = 0; i < TIME; i++) {
            try {
                System.out.println("produce: " + i);
                box.put(i);
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
