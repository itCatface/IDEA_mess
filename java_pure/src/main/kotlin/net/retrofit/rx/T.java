package net.retrofit.rx;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class T {

    public static void main(String[] args) {
        t2();
    }

    private static void t2() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//新的配置
                .baseUrl("https://api.github.com/")
                .build();

        AApi api = retrofit.create(AApi.class);

        api.getGit().subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("complete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("error");
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("next");
                    }
                });

        /*api.getGit().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });*/
    }

    private static void t() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//新的配置
                .baseUrl("http://127.0.0.1:8080/")
                .build();

        AApi service = retrofit.create(AApi.class);

        /*service.login1("we", "34").enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                System.out.println(response);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println(t.toString());
            }
        });*/

//        service.login("cc", "rr");

        service.login("C", "r")               //获取Observable对象
                .subscribeOn(Schedulers.newThread())//请求在新的线程中执行
                .observeOn(Schedulers.io())         //请求完成后在io线程中执行
                .doOnNext(userInfo -> {
                    System.out.println("call..." + userInfo);
//                        saveUserInfo(userInfo);//保存用户信息到本地
                })
                .observeOn(Schedulers.io())//最后在主线程中执行
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("complete...");
                    }

                    @Override
                    public void onError(Throwable e) {
                        //请求失败
                        System.out.println("error" + e.toString());
                    }

                    @Override
                    public void onNext(String userInfo) {
                        //请求成功
                        System.out.println("next");
                    }
                });
    }

}
