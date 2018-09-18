package util.lang.util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 *  Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 *
 *  @desc 读取配置文件
 */
public class PropT {


    public static void main(String[] args) {
        String value = value("t1", "e");
        System.out.println(value);

        Map<String, String> all = all("D:\\test.properties");
        System.out.println(all);
    }


    /** 配置文件中无指定key时返回-->NullPointerException */
    public static String value(String filePath, String key, String defaultValue) {
        File file = new File(filePath);
        if (!file.exists()) return defaultValue;    // 校验文件不存在时返回默认值

        InputStream is = null;  // change file to stream
        try {
            is = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(is);
            return new String(properties.getProperty(key).getBytes("ISO-8859-1"), "utf-8");     // 中文乱码已处理
        } catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        } finally {
            try {
                if (null != is) is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Map<String, String> all(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) throw new RuntimeException("file dose not exist!");

        InputStreamReader is = null;
        Map<String, String> map = new HashMap<>();
        try {
            is = new InputStreamReader(new FileInputStream(file), "UTF-8");
            Properties properties = new Properties();
            properties.load(is);

            // way1: use Enumeration to visit the config
            /*Enumeration<?> enumeration = config.propertyNames();
            while (enumeration.hasMoreElements()) {
                String value = (String) enumeration.nextElement();
                System.out.println(value + "=" + config.getProperty(value));
            }

            // way2: use KeySet to visit the config
            Set<Object> keyset = config.keySet();
            Iterator<Object> itr = keyset.iterator();
            while (itr.hasNext()) {
                String key = itr.next().toString();
                System.out.println(key + "=" + config.getProperty(key));
            }*/

            // way3: use stringPropertyNames to visit the config
            Set<String> keySet = properties.stringPropertyNames();
            for (String key : keySet) {
                map.put(key, properties.getProperty(key));
            }
            return map;

        } catch (Exception e) {
            e.printStackTrace();
            return map;

        } finally {
            try {
                if (null != is) is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /** 固定文件读取值 */
    private static final String pathProperties = "D:\\test.properties";

    public static String value(String key, String defaultValue) {
        return value(pathProperties, key, defaultValue);
    }
}
