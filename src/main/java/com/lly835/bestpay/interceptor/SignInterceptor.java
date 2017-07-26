package com.lly835.bestpay.interceptor;

import okhttp3.*;
import okio.Buffer;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.glassfish.jersey.message.internal.ReaderWriter.UTF8;

/**
 * Created by 廖师兄
 * 2017-07-25 下午8:38
 */
public class SignInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        //在这里获取到request后就可以做任何事情了
        Request request = chain.request();

        RequestBody requestBody= request.body();
        Buffer buffer = new Buffer();
        requestBody.writeTo(buffer);
        Charset charset = Charset.forName("UTF-8");
        MediaType contentType = requestBody.contentType();
        if (contentType != null) {
            charset = contentType.charset(UTF8);
        }
        String paramsStr = buffer.readString(charset);
        System.out.println(paramsStr);

        Response response = chain.proceed(request);
        return response;
    }
}
