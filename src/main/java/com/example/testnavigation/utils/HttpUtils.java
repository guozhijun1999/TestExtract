package com.example.testnavigation.utils;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class HttpUtils {
    public static RequestBody getBody(String json,String head){
        RequestBody requestBody=null;
        if (json!=null){
            requestBody=RequestBody.create(MediaType.parse(head),json);
        }
        return requestBody;
    }

}
