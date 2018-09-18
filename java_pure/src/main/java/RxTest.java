import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class RxTest {
    private static final String TAG = RxTest.class.getSimpleName();

    public static void main(String[] args) {
        rx01();
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
