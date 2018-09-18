package util.net.retrofit_xy;


import domain.InitData;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;
import util.net.retrofit_xy.domain.WriteSimCard;

import java.util.Map;

/**
 * Created by Xuyan on 2018/5/30.
 * email:q6642992@163.com
 */

public interface ApiService {
    @GET("app/user/changeNewLogin")
    Observable<InitData> getLogin();

    @FormUrlEncoded
    @POST("api/getIssueData")
    Observable<WriteSimCard> writeSimCard(@FieldMap Map<String, String> fields);
}
