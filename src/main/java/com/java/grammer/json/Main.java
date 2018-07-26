package com.java.grammer.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Main {

    public static void main(String[] args){
        String ret = "{\"workflowParam\":{\"json\":[{\"appName\":\"WPS Office\",\"icon\":\"http://img01.taobaocdn.com/tfscom/TB1EGDKbFooBKNjSZPhXXc2CXXa?resid=TB1EGDKbFooBKNjSZPhXXc2CXXa\",\"packageName\":\"cn.wps.moffice_eng\",\"downloadUrl\":\"http://download.tbcache.com/L0/tfs/LB19xPemYuWBuNjSszgXXb8jVXa\",\"appType\":\"apk\"},{\"appName\":\"test3\",\"icon\":\"/static/v2/image/app_default.png\",\"packageName\":\"com.app.test3\",\"downloadUrl\":\"\",\"appType\":\"apk\"}],\"enable\":\"true\"},\"workflowName\":\"set_app_whitelist\"}";
        JSONObject json = JSON.parseObject(ret);
        System.out.println(json.get("workflowParam"));
    }

}
