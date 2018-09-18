package design_pattern.single_instance;

/**
 * Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class Normal2 {

    private static Normal2 mInstance;

    public static Normal2 getInstance() {
        if (null == mInstance) {
            synchronized (Normal2.class) {
                Normal2 instance = mInstance;
                if (null == instance) {
                    instance = new Normal2();
                    mInstance = instance;
                }
            }
        }
        return mInstance;
    }

    Normal2() {
        System.out.println(Normal2.class.getSimpleName() + "初始化");
    }

    public void show() {
        System.out.println(Normal2.class.getSimpleName() + " --> show");
    }

}
