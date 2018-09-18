package design_pattern.single_instance;

/**
 * Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class NormalUpgrade {

    private static volatile NormalUpgrade mInstance;

    public static NormalUpgrade getInstance() {
        NormalUpgrade instance = mInstance;
        if (null == instance) {
            synchronized (NormalUpgrade.class) {
                instance = mInstance;
                if (null == instance) {
                    instance = new NormalUpgrade();
                    mInstance = instance;
                }
            }
        }

        return instance;
    }

    NormalUpgrade() {
        System.out.println(NormalUpgrade.class.getSimpleName() + "初始化");
    }

    public void show() {
        System.out.println(NormalUpgrade.class.getSimpleName() + " --> show");
    }
}
