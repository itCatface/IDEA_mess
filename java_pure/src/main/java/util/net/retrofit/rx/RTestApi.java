package util.net.retrofit.rx;


import retrofit2.http.GET;
import rx.Observable;


/**
 * Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public interface RTestApi {

    @GET(".")
    Observable<String> getAllUser();
}
