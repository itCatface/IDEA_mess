import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.*;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class RxTest {
    private static final String TAG = RxTest.class.getSimpleName();

    public static void main(String[] args) {
        //        rx01();

        String[] strs = {"张三", "李四"};
        Double[] nums = {2.12d, 32.34d};
        //        System.out.println(Arrays.toString(strs));
        //        System.out.println(strs.toString());

        Map<String, String> map = new HashMap<>();
        map.put("zhangsan", "111");
        map.put("wanger", "222");
        //        System.out.println(map.toString());


        List<String> list= new ArrayList<>();
        list.add("zhangsan");
        list.add("zhangsan1");

        sout(strs);
        sout(nums);

        sout(map);

        sout("dsf");
        sout(list);
    }


    private static void sout(Object t) {
        if (t instanceof String) {
            System.out.println(t);
        } else if (t instanceof Object[]) {
            System.out.println(Arrays.toString((Object[]) t));
        }else if (t instanceof List){
            System.out.println(t.toString());
        }else if (t instanceof Map) {
            System.out.println(t.toString());
        }
    }


    private static void rx01() {
        System.out.println(TAG + "==rx01-start...");

        Observable.create((ObservableOnSubscribe<String>) emitter -> {
            emitter.onNext("Ahri");
            emitter.onNext("Akali");
            emitter.onNext("Alistar");
            emitter.onNext("Amumu");
            emitter.onNext("Anivia");
            int i = 1 / 0;
            emitter.onComplete();
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println(TAG + "==rx01-onSubscribe");
            }

            @Override
            public void onNext(String str) {
                System.out.println(TAG + "==onNext-" + str);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(TAG + "==onError-" + e.toString());
            }

            @Override
            public void onComplete() {
                System.out.println(TAG + "==onComplete");
            }
        });
    }
}
