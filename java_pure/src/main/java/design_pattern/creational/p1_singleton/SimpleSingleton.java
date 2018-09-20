package design_pattern.creational.p1_singleton;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class SimpleSingleton {

    private static class Holder {
        private static final SimpleSingleton holder = new SimpleSingleton();
    }


    public static SimpleSingleton getHolder() {
        return Holder.holder;
    }


    private SimpleSingleton() {
        System.out.println(getClass().getSimpleName() + " --> 创建..." + Holder.holder);
    }


    public void show() {
        System.out.println(getClass().getSimpleName() + " --> showing..." + Holder.holder);
    }

}
