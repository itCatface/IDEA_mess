package design_pattern.creational.p1_singleton;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class NormalPreSingleton {

    private static volatile NormalPreSingleton mInstance;

    public static NormalPreSingleton getInstance() {
        NormalPreSingleton instance = mInstance;
        if (null == instance) {
            synchronized (NormalPreSingleton.class) {
                instance = mInstance;
                if (null == instance) {
                    instance = new NormalPreSingleton();
                    mInstance = instance;
                }
            }
        }

        return instance;
    }


    private NormalPreSingleton() {
        System.out.println(getClass().getSimpleName() + " --> 创建..." + mInstance);
    }


    public void show() {
        System.out.println(getClass().getSimpleName() + " --> showing..." + mInstance);
    }

}
