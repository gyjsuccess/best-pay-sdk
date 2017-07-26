package com.lly835.bestpay.config;

import com.lly835.bestpay.interceptor.SignInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by 廖师兄
 * 2017-07-25 下午8:45
 */
public class RetrofitConfig {

    /**
     * 创建Retrofit
     * @param baseUrl
     * @return
     */
    public static Retrofit build(String baseUrl) {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .addInterceptor(new SignInterceptor())
                .build();

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .client(client)
                .build();
    }
}
