package com.gateway.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author z
 */
public class Response {
    /**
     * 接口成功的通用返回值
     * @param object
     * @return
     */
    public static Map<String,Object> commonSuccess(Object object){
        Map<String,Object> response = new HashMap<>(3);
        response.put("data",object);
        response.put("success",1);
        response.put("errorMessage","successful");
        return response;
    }

    /**
     * 接口失败的通用返回值
     * @param errorMessage
     * @return
     */
    public static Map<String,Object> commonFail(String errorMessage){
        Map<String,Object> response = new HashMap<>(2);
        response.put("success",0);
        response.put("errorMessage",errorMessage);
        return response;
    }



}
