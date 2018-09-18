package util.net.retrofit_xy;

/**
 * Created by Xuyan on 2018/5/30.
 * email:q6642992@163.com
 */

public interface SubscriberListener<T> {
    void onNext(T t);
    void onException(String message);//其他数据层异常
    void onComplete();
}
