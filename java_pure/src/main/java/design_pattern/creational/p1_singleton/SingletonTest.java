package design_pattern.creational.p1_singleton;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925

 @desc 当类只能有一个实例且客户可以从任何地方访问之 */

public class SingletonTest {

    public static void main(String[] args) {

        testNormalSingleton();
        testNormal2Singleton();
        testNormalPreSingleton();
        testSimpleSingleton();
    }

    private static void testNormalSingleton() {
        NormalSingleton.getInstance().show();
        NormalSingleton.getInstance().show();
    }


    private static void testNormal2Singleton() {
        Normal2Singleton.getInstance().show();
        Normal2Singleton.getInstance().show();
    }


    private static void testNormalPreSingleton() {
        NormalPreSingleton.getInstance().show();
        NormalPreSingleton.getInstance().show();
    }


    private static void testSimpleSingleton() {
        SimpleSingleton.getHolder().show();
        SimpleSingleton.getHolder().show();
    }
}
