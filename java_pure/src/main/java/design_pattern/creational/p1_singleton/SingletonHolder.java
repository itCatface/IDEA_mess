package design_pattern.creational.p1_singleton;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925

 推荐使用该方式创建单例
 */
public class SingletonHolder {

    private static class Holder {
        private static final SingletonHolder holder = new SingletonHolder();
    }


    public static SingletonHolder getHolder() {
        return Holder.holder;
    }


    private SingletonHolder() {
        System.out.println(getClass().getSimpleName() + " --> 创建..." + Holder.holder);
    }


    public void show() {
        System.out.println(getClass().getSimpleName() + " --> showing..." + Holder.holder);
    }

}
