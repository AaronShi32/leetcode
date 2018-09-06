package middleware;

import com.taobao.diamond.client.Diamond;

import java.io.IOException;
import java.util.Arrays;

public class DiamondMain {

    public static void main(String[] args){
        try {
            String config = Diamond.getConfig("com.yunos.mdm.account.free.login.list", "yunos_mdm_group", 10000);
            String[] de = config.split("\r\n");
            System.out.println(Arrays.toString(de));
            System.out.println(de[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
