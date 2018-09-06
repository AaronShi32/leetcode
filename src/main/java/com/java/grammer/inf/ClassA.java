package com.java.grammer.inf;

public final class ClassA {

    public final int method(final int m, final int n){
        return 0;
    }

    public static void main(String[] args){
        final A Aa = new A();
        final A Ab = new A();
        System.out.println(Aa.i);
        System.out.println(Ab.i);
        System.out.println(Aa.j);
        System.out.println(Ab.j);
    }
}

class A {
    public final double i =  Math.random();
    public static double j = Math.random();
}
