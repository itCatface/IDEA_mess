package util.net;

import com.google.gson.Gson;
import domain.WriteSimCard;
import extention.T;
import retrofit2.http.GET;

import java.lang.reflect.Type;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class GsonT {

    public  static T  get(String json) {
        T t = new Gson().fromJson(json, T.class);
        return t;
    }


    //根据泛型返回解析制定的类型
    public static  <T> T fromToJson(String json,Type listType){
        Gson gson = new Gson();
        T t = null;
        t = gson.fromJson(json,listType);
        return t;
    }

    /*public static void main(String[] args) {
        WriteSimCard t =<WriteSimCard> get("");
    }*/
}
