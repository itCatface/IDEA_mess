package design_pattern.creational.p1_singleton;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class NormalSingleton {

    private static NormalSingleton mInstance;

    public static NormalSingleton getInstance() {
        if (null == mInstance) {
            synchronized (NormalSingleton.class) {
                if (null == mInstance) {
                    mInstance = new NormalSingleton();
                }
            }
        }

        return mInstance;
    }


    private NormalSingleton() {
        System.out.println(getClass().getSimpleName() + " --> 创建..." + mInstance);
    }


    public void show() {
        System.out.println(getClass().getSimpleName() + " --> showing..." + mInstance);
    }

}
