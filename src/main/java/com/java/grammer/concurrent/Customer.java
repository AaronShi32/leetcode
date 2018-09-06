package com.java.grammer.concurrent;

public class Customer implements Runnable {

    private Product product;
    private int TIME = 20;

    public Customer(Product product){
        this.product = product;
    }

    @Override
    public void run() {
        for(int i = 0; i < TIME; i++) {
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.product.dec();
        }
    }
}
