package design_pattern.creational.p1_singleton;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925

 双重检查锁创建单例方式如下
 */
public class SingletonDCLPreVolatile {

    private static volatile SingletonDCLPreVolatile mInstance;

    public static SingletonDCLPreVolatile getInstance() {
        SingletonDCLPreVolatile instance = mInstance;
        if (null == instance) {
            synchronized (SingletonDCLPreVolatile.class) {
                instance = mInstance;
                if (null == instance) {
                    instance = new SingletonDCLPreVolatile();
                    mInstance = instance;
                }
            }
        }

        return instance;
    }


    private SingletonDCLPreVolatile() {
        System.out.println(getClass().getSimpleName() + " --> 创建..." + mInstance);
    }


    public void show() {
        System.out.println(getClass().getSimpleName() + " --> showing..." + mInstance);
    }

}
