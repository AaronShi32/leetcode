package grammer.encode;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args){

        String name = "I am 晨升.";

        try {
            System.out.println("CharArray: " + Arrays.toString(name.toCharArray()));

            byte[] iso8859 = name.getBytes("ISO-8859-1");
            System.out.println("ISO8859: " + Arrays.toString(iso8859));

            byte[] gb2312 = name.getBytes("GB2312");
            System.out.println("GB2312: " + Arrays.toString(gb2312));

            byte[] gbk = name.getBytes("GBK");
            System.out.println("GBK: " + Arrays.toString(gbk));

            byte[] utf16 = name.getBytes("UTF-16");
            System.out.println("UTF16: " + Arrays.toString(utf16));

            byte[] utf8 = name.getBytes("UTF-8");
            System.out.println("UTF8: " + Arrays.toString(utf8));

        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }


    }
}
