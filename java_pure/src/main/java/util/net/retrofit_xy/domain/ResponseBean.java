package util.net.retrofit_xy.domain;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.lang.reflect.Type;

/**
 * Created by Xuyan on 2018/5/30.
 * email:q6642992@163.com
 */

public class ResponseBean<T> {
    private String message;
    private int code;
    private JsonElement data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public JsonElement getData() {
        return data;
    }

    public void setData(JsonElement data) {
        this.data = data;
    }

    public T getDataBean(Class<T> clazz){
        if (clazz==getClass()){
            return (T)this;
        }
        if (data!=null){
            try{
                Gson gson =new Gson();
                T t = gson.fromJson(data,clazz);
                return t;
            }catch (Exception e){

            }

        }
        return null;
    }

    public T getDataBean(Type type){
        if (data!=null){
            Gson gson =new Gson();
            T t = gson.fromJson(data,type);
            return t;
        }
        return null;
    }
}
