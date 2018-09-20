package design_pattern.creational.p1_singleton;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class Normal2Singleton {

    private static Normal2Singleton mInstance;

    public static Normal2Singleton getInstance() {
        if (null == mInstance) {
            synchronized (Normal2Singleton.class) {
                Normal2Singleton instance = mInstance;
                if (null == instance) {
                    instance = new Normal2Singleton();
                    mInstance = instance;
                }
            }
        }

        return mInstance;
    }


    private Normal2Singleton() {
        System.out.println(getClass().getSimpleName() + " --> 创建..." + mInstance);
    }


    public void show() {
        System.out.println(getClass().getSimpleName() + " --> showing..." + mInstance);
    }
}
