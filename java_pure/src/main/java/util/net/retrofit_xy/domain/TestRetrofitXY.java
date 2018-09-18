package util.net.retrofit_xy.domain;

import domain.InitData;
import util.net.retrofit_xy.HttpUtils;
import util.net.retrofit_xy.ResponseSubscribe;
import util.net.retrofit_xy.SubscriberListener;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class TestRetrofitXY {

    public static void main(String[] args) {

        System.out.println("开始请求...");
        HttpUtils.getHttpUtils().PostLogin(new ResponseSubscribe(new SubscriberListener<InitData>() {
            @Override
            public void onNext(InitData initData) {
                System.out.println("nex: " + initData.toString());
            }

            @Override
            public void onException(String message) {
                System.out.println("onException: " + message);
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete.");
            }
        }));
    }
}
