package design_pattern.creational.p1_singleton;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class SingletonDCL {

    private static SingletonDCL mInstance;

    public static SingletonDCL getInstance() {
        if (null == mInstance) {
            synchronized (SingletonDCL.class) {
                if (null == mInstance) {
                    mInstance = new SingletonDCL();
                }
            }
        }

        return mInstance;
    }


    private SingletonDCL() {
        System.out.println(getClass().getSimpleName() + " --> 创建..." + mInstance);
    }


    public void show() {
        System.out.println(getClass().getSimpleName() + " --> showing..." + mInstance);
    }

}
