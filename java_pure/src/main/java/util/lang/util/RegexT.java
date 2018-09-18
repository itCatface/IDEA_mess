package util.lang.util;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexT {

    private static RegexT mInstance;

    public static RegexT getInstance() {
        if (null == mInstance) {
            synchronized (RegexT.class) {
                if (null == mInstance) {
                    mInstance = new RegexT();
                }
            }
        }

        return mInstance;
    }


    /*** 正则包含 ***/
    public boolean contains(String str, String pattern) {
        pattern = ".*" + pattern + ".*";
        return Pattern.matches(pattern, str);
    }


    /*** 正则IP ***/
    public void ip() {
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        while (m.find()) {
            System.out.println(m.group());
        }

        /*if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }*/
    }

    /**
     * ip
     */
    public static final String IP = "^((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))$";

    /**
     * phone number
     */
    public static final String PHONE_NUMBER = "^1{1}(3{1}\\d{1}|5{1}[012356789]{1}|8{1}[035689]{1})\\d{8}$";

    /**
     * email[be able to dismiss "www."]
     */
    public static final String EMAIL = "^(www\\.)?\\w+@\\w+(\\.\\w+)+$";

    /**
     * Chinese characters
     */
    public static final String CHINESE_CHARACTERS = "^[\u4e00-\u9f5a]+$";

    /**
     * positive integer
     */
    public static final String POSITIVE_INTEGER = "^\\d+$";

    /**
     * id card number
     */
    public static final String ID_CARD = "^(\\d{6})(19|20)(\\d{2})(1[0-2]|0[1-9])(0[1-9]|[1-2][0-9]|3[0-1])(\\d{3})(\\d|X|x)?$";

    /**
     * zip code
     */
    public static final String ZIP_CODE = "^\\d{6}$";

    /**
     * url
     */
    public static final String URL = "^(([hH][tT]{2}[pP][sS]?)|([fF][tT][pP]))\\:\\/\\/[wW]{3}\\.[\\w-]+\\.\\w{2,4}(\\/.*)?$";


    public static boolean iz(String str, String regex) {
        return str.matches(regex);
    }
}
