package util.net.retrofit.rx;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

import java.util.Date;
import java.util.Random;

/**
 * Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class RTest {

    private static Retrofit retrofit;
    private static RTestApi retrofitInterface;

    private static void initRetrofit(String baseUrl) {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        //创建Retrofit接口对象
        retrofitInterface = retrofit.create(RTestApi.class);
    }

    public static void main(String[] args) {

//        from();
//        just();
//        map();
//        flatMap();
//        scan();
//        elementAt();
//        merge();
//        zip();
//        other();
//        on();
        getAllUser();

//        t();
//
//        test();
//
//        initRetrofit("http://127.0.0.1:8080/test_sql/getAllUser/");
//        getAllUser();
    }


    static final String[] csb = new String[]{"先帝创业未半而中道崩殂", "今天下三分", "益州疲弊", "此诚危急存亡之秋也", "然侍卫之城不懈于内", "忠志之士忘身于外者"};

    static void from() {
        /* from-->接收数组并按顺序发射数据 */
        Observable.from(csb)
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("---from complete---\n");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println(s);
                    }
                });
    }


    static void just() {
        /* just-->最多接收10个参数并按顺序发射 */
        Observable.just("先帝创业未半而中道崩殂", "今天下三分", "益州疲弊", "此诚危急存亡之秋也", "然侍卫之城不懈于内", "忠志之士忘身于外者")
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("---just complete---\n");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println(s);
                    }
                });
    }


    static void map() {
        /* map-->对原始数据二次加工 */
        Observable.from(csb)
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return "[" + new Date().toLocaleString() + "]" + s;
                    }
                }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("---map complete---\n");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        });
    }

    static void flatMap() {
        /* flatMap-->接收Observable函数作为入参并在此基础创建新的Observable后输出 */
        Observable.from(csb)
                .flatMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String s) {
                        return Observable.from(new String[]{s + "[" + new Date().toLocaleString() + "]"});
                    }
                }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("---flatMap complete---\n");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        });
    }


    static void concatMap() {
        Observable.from(csb)
                .concatMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String s) {
                        return Observable.from(new String[]{s + "[" + new Date().toLocaleString() + "]"});
                    }
                }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("---flatMap complete---\n");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        });
    }


    static void scan() {
        /* scan-->累加器 */
        Observable.just(1, 2, 3, 4, 5)
                .scan(new Func2<Integer, Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer, Integer integer2) {
                        return integer + integer2;
                    }
                }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("---scan[int] complete---\n");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }
        });

        Observable.just("难", "受", "啊", "!", "马", "飞", "!")
                .scan(new Func2<String, String, String>() {
                    @Override
                    public String call(String s, String s2) {
                        return s + s2;
                    }
                }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("---scan[String] complete---\n");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        });
    }


    static void elementAt() {
        /* elementAt-->获取数据源中的某个索引位置的值 */
        Observable.just("艾欧尼亚", "祖安", "诺克萨斯", "班德尔城")
                .elementAt(new Random().nextInt(4))
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("---elementAt complete---\n");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println(s);
                    }
                });
    }


    static void merge() {
        /* merge-->合并多个数据源并按顺序发射 */
        Observable<String> just1 = Observable.just("苟利国家生死以", "岂因福祸避趋之");
        Observable<String> just2 = Observable.just("鞠躬尽瘁", "死而后已");
        Observable.merge(just1, just2)
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("---merge complete---\n");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println(s);
                    }
                });
    }


    static void zip() {
        Observable<String> just1 = Observable.just("苟利国家生死以", "岂因福祸避趋之");
        Observable<String> just2 = Observable.just("鞠躬尽瘁", "死而后已");
        Observable.zip(just1, just2, new Func2<String, String, Object>() {
            @Override
            public Object call(String s, String s2) {
                return s + "--" + s2;
            }
        }).subscribe(new Subscriber<Object>() {
            @Override
            public void onCompleted() {
                System.out.println("---zip complete---\n");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
                System.out.println(o.toString());
            }
        });
    }


    static void other() {
        Observable.just(1, 2, 3, 4, 5, 6, 8, 9, 10, 9)
                .startWith(2)
                .filter(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return integer > 4;
                    }
                }).take(2)      // 只发射前n个元素
//                .takeLast(2)  // 只发射最后n个元素
//                .first()      // 只发射第一个元素
//                .last()       // 只发射最后一个元素
//                .skip(2)      // 跳过前n个元素
//                .skipLast(2)  // 跳过最后n个元素
                .distinct()     // 过滤重复元素
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("---other complete---\n");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println(integer);
                    }
                });
    }


    static void on() {
        Observable<String> just1 = Observable.just("苟利国家生死以", "岂因福祸避趋之");
        Observable<String> just2 = Observable.just("鞠躬尽瘁", "死而后已");
        Observable.zip(just1, just2, new Func2<String, String, Object>() {
            @Override
            public Object call(String s, String s2) {
                System.out.println(Thread.currentThread().getName());
                return s + "---" + s2;
            }
        })
                .subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.io())
                .subscribe(new Subscriber<Object>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("---on complete---\n");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Object o) {
                        System.out.println(Thread.currentThread().getName());
                        System.out.println(o.toString());
                    }
                });
    }


    static void getAllUser() {
        new Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8080/test_sql/getAllUser/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(RTestApi.class)
                .getAllUser()
//                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.trampoline())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("---getAllUser complete---\n");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.toString());
                    }

                    @Override
                    public void onNext(String result) {
                        System.out.println(result);
                    }
                });
    }

}

