package com.leetcode.prime;

import java.util.ArrayList;
import java.util.List;

//CIDR: 网络ID + 主机ID = IP, IP/n 网络位数

public class MIPtoCIDR {

    public static List<String> ipToCIDR(String ip, int range) {
        long x = 0;
        //获得一个ip地址每一部分
        String[] ips = ip.split("\\.");
        //将整ip地址看为一个整体，求出整体的int表示
        for (int i = 0; i < ips.length; ++i) {
            x = Integer.parseInt(ips[i]) + x * 256;
        }
        List<String> ans = new ArrayList<>();
        while (range > 0) {
            //求出二进制表示下的最低有效位的位数能表示的地址的数量
            //如果为奇数，则=1，即以原单个起始ip地址为第一块
            //如果为偶数，则二进制表示下的最低有效位的位数能表示的地址的数量
            long step = x & -x;
            //如果大于range，则需要缩小范围
            while (step > range) step /= 2;
            //不大于需要的range，开始处理
            //求出现在能表示的step个地址的地址块
            ans.add(longToIP(x, (int) step));
            //x加上以求出的地址块
            x += step;
            //range减去以表示的地址块
            range -= step;
        }//直到range<0
        return ans;
    }

    static String longToIP(long x, int step) {
        int[] ans = new int[4];
        //&255操作求出后8位十进制表示
        ans[0] = (int) (x & 255);
        //右移8位，即求下一个块
        x >>= 8;
        ans[1] = (int) (x & 255);
        x >>= 8;
        ans[2] = (int) (x & 255);
        x >>= 8;
        ans[3] = (int) x;
        int len = 33;
        //每一位就可以表示2个
        while (step > 0) {
            len--;
            step /= 2;
        }
        return ans[3] + "." + ans[2] + "." + ans[1] + "." + ans[0] + "/" + len;
    }

    public static void main(String[] args) {
        System.out.println(ipToCIDR("255.0.0.7", 10));

        //当一个偶数与它的负值相与时, 结果是能被这个偶数整除的最大的2的幂
        //如果是x是奇数, 那x & -x 的结果一定是1
        int x = 32;
        System.out.println(x & -x);
        x = 1;
        System.out.println(x & -x);
        x = 0;
        System.out.println(x & -x);
        x = 28;
        System.out.println(x & -x);
        x = 24;
        System.out.println(x & -x);


    }

}
