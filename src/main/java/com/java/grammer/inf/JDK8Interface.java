package com.java.grammer.inf;

public interface JDK8Interface {

    int i = 9;

    static void f(){
        System.out.println("from base inf y");
    }

    default void m(){
        System.out.println("from base inf");
    }

    void turn();

}
