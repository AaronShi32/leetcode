package com.java.grammer.date;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws ParseException {
        Calendar cal = Calendar.getInstance();
        Long time = System.currentTimeMillis() + 1000 * 60 * 60;
        cal.setTimeInMillis(time);
        System.out.println(dateFormat.parse(dateFormat.format(cal.getTime())));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.parse("2015-01-01 00:00:00").getTime());
        System.out.println(sdf.parse("2018-04-01 23:59:59").getTime());

        BigDecimal a = new BigDecimal(1.2);
        System.out.println(a.add(new BigDecimal(0.3)));
        System.out.println(a);

    }
}
