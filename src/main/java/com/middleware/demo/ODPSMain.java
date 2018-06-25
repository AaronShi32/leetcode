package com.middleware.demo;

import com.aliyun.odps.Odps;
import com.aliyun.odps.account.Account;
import com.aliyun.odps.account.AliyunAccount;

import java.net.MalformedURLException;
import java.net.URL;

public class ODPSMain {

    public static void main(String[] args) throws MalformedURLException {
//        Account account = new AliyunAccount(accessKey, accessSecret);
//        Odps odps = new Odps(account);
//        String odpsUrl = "<your odps endpoint>";
//        odps.setEndpoint(odpsUrl);
//        odps.setDefaultProject("my_project");
        //System.out.println( 1 | 2);
        URL url = new URL("http://www.cnblogs.com/toutou");
        System.out.println(url.getPath());

    }
}
