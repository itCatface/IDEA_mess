package net.retrofit.rx;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public interface AApi {

    @POST("hi/login")
    Call<String> login1(@Query("username") String username, @Query("password") String password);

    @POST("hi/login")
    Observable<String> login(@Query("username") String username, @Query("password") String password);

    @GET(".")
    Observable<String> getGit();


}
