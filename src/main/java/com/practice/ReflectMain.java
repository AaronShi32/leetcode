package com.topic.interview;

import java.lang.reflect.Field;

public class ReflectMain {

    public static void main(String[] args) throws Exception {
        System.out.println();

        Class X = Class.forName("com.topic.practice.A");
        Field f = X.getDeclaredField("a");
        f.setAccessible(true);
        System.out.println(f.getInt(X.newInstance()));
    }

}

class A {
    private int a = 1;
}
