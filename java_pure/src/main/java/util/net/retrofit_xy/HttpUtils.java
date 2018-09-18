package util.net.retrofit_xy;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import domain.InitData;
import okhttp3.*;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import util.net.retrofit_xy.domain.ResponseBean;
import util.net.retrofit_xy.domain.WriteSimCard;

/**
 Created by Xuyan on 2018/5/30.
 email:q6642992@163.com
 */

public class HttpUtils {
    private Map<Observable, Subscription> map;
    //    private static String baseUrl="";//正式环境
    private static String baseUrl = "http://127.0.0.1:8080/";//测试环境
    private Retrofit retrofit;
    private static int TIME_OUT = 2000;
    private static ApiService apiService;

    private HttpUtils() {
        map = new HashMap<>();
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .addInterceptor(new RetrofitInterceptor()).build();
        okHttpClient.newBuilder().connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public static HttpUtils getHttpUtils() {
        return ViewHolder.httpUtils;
    }

    private static class ViewHolder {
        private static HttpUtils httpUtils = new HttpUtils();
    }

    public <T> void toSubscribe(Observable<T> o, Subscriber<T> subscriber) {
        Subscription subscription = o


//                .subscribeOn(Schedulers.io())

                .observeOn(Schedulers.io())


                .subscribe(subscriber);
        map.put(o, subscription);
    }


    /**
     取消订阅
     */
    public void cancleSub(Observable observable) {
        if (map != null && map.size() > 0) {
            map.get(observable).unsubscribe();
            map.remove(observable);
        }
    }

    /**
     全部取消订阅
     */
    public void cancleAll() {
        if (map != null && map.size() > 0) {
            for (Observable observable : map.keySet()) {
                map.get(observable).unsubscribe();
            }
            map.clear();
        }
    }


    /**
     登陆接口
     */
    public void PostLogin(Subscriber<InitData> subscriber) {
        Observable observable = apiService.getLogin();
        toSubscribe(observable, subscriber);
    }

    public void writeSimCard(Map<String, String> map, Subscriber<ResponseBean<WriteSimCard>> subscriber) {
        Observable observable = apiService.writeSimCard(map);
        toSubscribe(observable, subscriber);
    }
}
