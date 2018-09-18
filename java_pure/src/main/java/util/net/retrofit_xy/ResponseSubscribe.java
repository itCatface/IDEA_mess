package util.net.retrofit_xy;


import rx.Subscriber;
import util.net.LogT;
import util.net.retrofit_xy.domain.ResponseBean;
import util.net.retrofit_xy.domain.WriteSimCard;

/**
 Created by Xuyan on 2018/5/30.
 email:q6642992@163.com
 */

public class ResponseSubscribe<T> extends Subscriber<T> {
    private SubscriberListener<T> subscriberListener;
    private String TAG = this.getClass().getSimpleName();

    public ResponseSubscribe(SubscriberListener subscriberListener) {
        this.subscriberListener = subscriberListener;
    }


    @Override
    public void onCompleted() {
        LogT.d(TAG, "onCompleted: 数据请求完成");
    }

    @Override
    public void onError(Throwable e) {
        LogT.d(TAG, "onError: " + e.getMessage());
    }

    @Override
    public void onNext(T t) {

        WriteSimCard initData = (WriteSimCard) t;
        System.out.println(t.toString());


        if (!this.isUnsubscribed()) {
            if (t == null) {
                return;
            }
            if (subscriberListener != null) {
                ResponseBean responseBean = (ResponseBean) t;
                switch (responseBean.getCode()) {
                    case 500://网络异常
                        LogT.d(TAG, "error: " + responseBean.getMessage());
                        subscriberListener.onException(responseBean.getMessage());
                        break;
                    case 200:
                        subscriberListener.onNext(t);
                        break;
                    default:
                        LogT.d(TAG, responseBean.getMessage());
                        break;
                }
            }
        } else {
            LogT.d(TAG, "onNext: 订阅取消");
        }

    }
}
