package com.java.grammer;

public class Main extends Base{

    public void changeWorld(){
        System.out.println("override wanna change world?");
    }

    public static void main(String[] args){
        Main runner = new Main();
        runner.sayHello();
    }
}
