package com.java.grammer.regex;

import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args){
        System.out.println("dsadsa".hashCode());
        System.out.println("dsadsa".hashCode());
    }

    public static String isValid(String ip){
        boolean isMatch = Pattern.matches("^((25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))$", ip);
        if(isMatch){
            return "IPV4";
        }
        isMatch = Pattern.matches("^([\\da-fA-F]{1,4}:){7}([\\da-fA-F]{1,4})$", ip);
        if(isMatch){
            return "IPV6";
        }
        return "Neither";
    }

}
