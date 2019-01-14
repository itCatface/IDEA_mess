package design_pattern.creational.p1_singleton;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public enum SingletonEnum {

    INSTANCE;

    public void doSomething() {
        System.out.println("create singleton by enum..." + getClass().getSimpleName() + " --> showing..." + INSTANCE);
    }
}
