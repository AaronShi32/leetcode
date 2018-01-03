package com.topic.concurrent.communication;

public class Product {

    private final static int MAX = 10;
    private static int product = 0;

    public synchronized void inc(){
        while(product ==  MAX){
            try{
                wait();
                System.out.println("产品已满,稍候生产");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        product++;
        System.out.println("生产者生产第 " + product + " 个产品.");
        notify();
    }

    public synchronized void dec(){
        while(product == 0){
            try{
                wait();
                System.out.println("缺货");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("消费者取走了第 " + product + " 个产品.");
        product--;
        notify();
    }
}
