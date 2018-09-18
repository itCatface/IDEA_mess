package design_pattern.single_instance;

/**
 * Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 * -
 * 最基础的懒加载单例
 */
public class Normal {

    private static Normal mInstance;

    public static Normal getInstance() {
        if (null == mInstance) {
            synchronized (Normal.class) {
                if (null == mInstance) {
                    mInstance = new Normal();
                }
            }
        }

        return mInstance;
    }

    Normal() {
        System.out.println(Normal.class.getSimpleName() + "初始化");
    }

    public void show() {
        System.out.println(Normal.class.getSimpleName() + " --> show");
    }
}
