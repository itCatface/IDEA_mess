package design_pattern.creational.p1_singleton;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class SingletonDCLPre {

    private static SingletonDCLPre mInstance;

    public static SingletonDCLPre getInstance() {
        if (null == mInstance) {
            synchronized (SingletonDCLPre.class) {
                SingletonDCLPre instance = mInstance;
                if (null == instance) {
                    instance = new SingletonDCLPre();
                    mInstance = instance;
                }
            }
        }

        return mInstance;
    }


    private SingletonDCLPre() {
        System.out.println(getClass().getSimpleName() + " --> 创建..." + mInstance);
    }


    public void show() {
        System.out.println(getClass().getSimpleName() + " --> showing..." + mInstance);
    }
}
