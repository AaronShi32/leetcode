package com.topic.concurrent;

import java.util.concurrent.BlockingQueue;

public class CustomQueue implements Runnable{

    private BlockingQueue box;
    private final static int TIME = 20;

    public CustomQueue(BlockingQueue box) {
        this.box = box;
    }

    @Override
    public void run() {
        for(int i = 0; i < TIME; i++) {
            try {
                System.out.println("custom:" + box.take());
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
