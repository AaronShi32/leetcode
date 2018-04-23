package com.middleware.demo;

import com.taobao.tair.impl.mc.MultiClusterTairManager;
import com.util.Date;

import java.util.Calendar;

public class TairMain {

    private static MultiClusterTairManager mcTairManager;

    private static final int NAMESPACE = 200;

    private static int day = 24 * 60 * 60;

    private static int week = day * 7;

    private static int month = week * 30;

    private static int half_year = month * 6;


    static {
        mcTairManager = new MultiClusterTairManager();
        mcTairManager.setUserName("market1-daily");
        mcTairManager.init();
    }



    public static void main(String[] args){
        Long currentTimeMills = System.currentTimeMillis();
        //mcTairManager.put(NAMESPACE, "furit", "apple", 1, 3);
        System.out.println(mcTairManager.get(NAMESPACE, "furit"));
        System.exit(0);
    }

}
