package design_pattern.single_instance;

/**
 * Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class Simple {

    private static class HelperHolder {
        private static final Simple helper = new Simple();
    }

    public static Simple getHelper() {
        return HelperHolder.helper;
    }

    Simple() {
        System.out.println("Simple初始化");
    }

    public void show() {
        System.out.println("Simple --> show");
    }
}
