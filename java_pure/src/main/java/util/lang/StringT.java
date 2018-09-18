package util.lang;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringT {


    /*** remove all \t \r \n in string ***/
    public static String clean(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }


    /*** parse stream to string ***/
    public static String stream2Str(InputStream is) {

        if (null == is || "".equals(is.toString())) return "";

        ByteArrayOutputStream baos = null;

        try {
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            baos.close();
            is.close();
            return baos.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return "";

        } finally {
            try {
                if (null != baos) baos.close();
                if (null != is) is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     parse stream to file
     */
    public static void stream2File(InputStream is, String savePath) {
        try {
            System.out.println("文件保存路径为:" + savePath);
            File file = new File(savePath);
            BufferedInputStream fis = new BufferedInputStream(is);
            FileOutputStream fos = new FileOutputStream(file);
            int f;
            while ((f = fis.read()) != -1) {
                fos.write(f);
            }
            fos.flush();
            fos.close();
            fis.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     parse string to stream
     */
    public static InputStream str2Stream(String str) {
        return new ByteArrayInputStream(str.getBytes());
    }


    /**
     JSON & MAP————————________————————________————————________————————________————————________————————JSON & MAP
     --
     parse json to map
     */
    public static Map map(String json) {
        return map(json, 2);
    }


    public static Map map(String json, int type) {

        Map map = new HashMap<String, String>();

        switch (type) {
            case 0:
                map = (Map) JSON.parse(json);
                break;

            case 1:
                map = JSON.parseObject(json);
                break;

            case 2:
                map = JSON.parseObject(json, Map.class);
                break;

            case 3:
                map = (Map) JSONObject.parse(json);
                break;

            case 4:
                map = JSONObject.parseObject(json);
                break;

            case 5:
                map = JSONObject.parseObject(json, Map.class);
                break;

            /*{"0":"zhangsan","1":"lisi","2":"wangwu","3":"maliu"}
            {"0":"zhangsan","1":"lisi","2":"wangwu","3":"maliu"}
            {0=zhangsan, 1=lisi, 2=wangwu, 3=maliu} // ==> map 集合的输出格式
            {"0":"zhangsan","1":"lisi","2":"wangwu","3":"maliu"}
            {"0":"zhangsan","1":"lisi","2":"wangwu","3":"maliu"}
            {0=zhangsan, 1=lisi, 2=wangwu, 3=maliu}*/
        }

        return map;
    }


    /**
     parse map to json
     */
    public static String json(Map map) {
        return JSON.toJSON(map).toString();
    }
}
