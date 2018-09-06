package com.java.grammer.inf;

public class JDK8Class implements  JDK8Interface{


    @Override
    public void turn() {
        System.out.println("Yueeeeeee");
    }

    public static void main(String[] args){
        JDK8Class c = new JDK8Class();
        c.turn();
        c.m();
        JDK8Interface.f();
    }


}
