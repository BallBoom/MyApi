package com.cn.utils;

import com.alibaba.fastjson.JSONObject;

public class ResponseMsg {


    public static String success(Object object){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("msg",1);
        jsonObject.put("data",object);
        return jsonObject.toString();
    }


    public static String fail(Object object){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("msg",0);
        return jsonObject.toString();
    }
}
