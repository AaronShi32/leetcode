package com.java.grammer.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectMain {

    public static final int a = 100;
    public static final Integer b = 100;

    public static void main(String[] args) throws Exception {

        // basic
        Class X = Class.forName("com.java.grammer.reflect.A");
        Field f = X.getDeclaredField("a");
        f.setAccessible(true);
        System.out.println(f.getInt(X.newInstance()));

        // 通过反射修改 final 变量
        // a. 基本类型无法通过反射修改, 因为编译时已经替换成常量值
        System.out.println("Before:" + a);
        f = ReflectMain.class.getField("a");
        f.setAccessible(true);
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(f, f.getModifiers() & ~Modifier.FINAL);
        f.set(null, 200);
        System.out.println("After:" + a);

        // b. 对象类型可以通过反射修改值或者对象内容
        System.out.println("Before:" + b);
        f = ReflectMain.class.getField("b");
        f.setAccessible(true);
        modifiersField.setInt(f, f.getModifiers() & ~Modifier.FINAL);
        f.set(null, 300);
        System.out.println("After:" + b);

    }

}

class A {
    private int a = 1;
}
