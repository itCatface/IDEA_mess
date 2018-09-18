package util.net.retrofit_xy;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class RetrofitInterceptor implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();


        System.out.println("url-->" + request.url());


        Request.Builder builder = request.newBuilder();
        request = builder.addHeader("token", "")
                .addHeader("code", "")
                .method(request.method(), request.body())
                .build();

        Response response = chain.proceed(request);


        return response;
    }


}
