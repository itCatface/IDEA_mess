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
        testEnumSingleton();
    }

    private static void testNormalSingleton() {
        SingletonDCL.getInstance().show();
        SingletonDCL.getInstance().show();
    }


    private static void testNormal2Singleton() {
        SingletonDCLPre.getInstance().show();
        SingletonDCLPre.getInstance().show();
    }


    private static void testNormalPreSingleton() {
        SingletonDCLPreVolatile.getInstance().show();
        SingletonDCLPreVolatile.getInstance().show();
    }


    private static void testSimpleSingleton() {
        SingletonHolder.getHolder().show();
        SingletonHolder.getHolder().show();
    }


    private static void testEnumSingleton() {
        SingletonEnum.INSTANCE.doSomething();
        SingletonEnum.INSTANCE.doSomething();
    }
}
