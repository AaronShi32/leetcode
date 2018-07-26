package com.java.grammer.file;

import java.io.File;

public class FileMain {

    public static void main(String[] args){

        File file = new File("src/main/resources/x.y.z.-a.png");

        System.out.println(file.getName());
    }

}
