package com.shijiawen.weather01.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

//    封装okHttp网络请求方式
public class HttpUtil {
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
