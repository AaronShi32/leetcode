package com.topic.concurrent;

public class Producer implements Runnable{

    private Product product;
    private int TIME = 20;

    public Producer(Product product){
        this.product = product;
    }

    @Override
    public void run() {
        for(int i = 0; i < TIME; i++) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.product.inc();
        }
    }
}
