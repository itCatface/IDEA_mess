package demo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.alibaba.fastjson.JSON;
import sun.misc.BASE64Encoder;
import sun.rmi.runtime.Log;
import util.en_decrypt.XOR;
import util.lang.util.DateT;
import util.net.http.imp.HttpT;

public class Test {

    public static int num;


    public static void main(String[] args) throws NoSuchAlgorithmException {
        //		System.out.println(num);
        //
        //		int b;
        //		String cString;

        // sumNo7_01(100, 7);
        // sumNo7_02(100, 7);

        //		System.out.println(str2Md5("111111") + "\n" + str2MD5("111111") + "\n" + md5("111111") + "\n" + MD5("111111") + "\n" + getIdHash(111111));

        //        float i = Float.parseFloat("0.0");
        //        System.out.println(i > -1);

        //        Scanner scanner = new Scanner(System.in);
        //        System.out.println("please enter your name:");
        //        String name = scanner.nextLine();
        //        System.out.println("please enter your age:");
        //        String age = scanner.nextLine();
        //        System.out.println(name + " || " + age);


        //        long l = DateT.netTimeStamp();
        //        String format = new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(l);
        //        System.out.println(l + " || " +format);

        //        String temp = "aa";
        //        switch (temp) {
        //            case "a":
        //                System.out.println("a");
        //                break;
        //            case "aa":
        //                System.out.println("aa");
        //            default:
        //                System.out.println("default");
        //                break;
        //        }


        //        sortInsert();
        //        sortShell();

        //        System.out.println(HttpT.getInstance().getT());
        //        System.out.println(Thread.currentThread().getName());


        //        String s = "qwer/r/nqasdf\r\nzxcv";
        //        System.out.println(s);


//        Map<String, String> map = new HashMap<>();
//        map.put("12", "df");
//        String a = JSON.toJSON(map).toString();
//        System.out.println(a);
//
//
//        for (int i = 1, j; i < 3; i++) {
//
//        }


//        XOR.encrypt("D:\\t\\l.jpg", "D:\\t\\l1.jpg");

//        StringBuffer[] md5 = new StringBuffer[4];

        Map<String, String> map = new HashMap<>();
        map.put("ss","sdsf");

        System.out.println("❥❥❥〓root〓蒂芬〓url:wwww. || map:" + map.toString());
        


    }



    private static int[] nums = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};

    // 希尔排序
    static void sortShell() {
        int d = nums.length;
        while (true) {
            d = d / 2;
            for (int i = 0; i < d; i++) {
                for (int j = i + d; j < nums.length; j = j + d) {
                    int temp = nums[j];
                    int k;
                    for (k = j - d; k >= 0 && nums[k] > temp; k = k - d) {
                        nums[k + d] = nums[k];
                    }
                    nums[k + d] = temp;
                }
            }
            System.out.println("第");
            soutArr();
            if (d == 1) {
                break;
            }
        }
    }


    //    static int[] nums = {5, 2, 8, 4, 9, 1};
    //    static int[] nums = {3, 6, 5, 7, 8, 1};


    // 插入排序
    static void sortInsert() {


        int temp, j;

        for (int i = 1; i < nums.length; i++) {
            temp = nums[i];
            j = i;
            while (j > 0 && temp < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;

            soutArr();
        }

    }


    static void soutArr() {
        String result = "";
        for (int i : nums) {
            result += i + " -- ";
        }
        result = result.substring(0, result.lastIndexOf(" -- "));
        System.out.println(result);
    }

    private static void sumNo7_01(int num, int skip) {

        int sum = 0;
        for (int i = 1; i <= num; i++) {
            if ((i + "").contains(skip + "")) {
                continue;
            }
            sum += i;
            System.out.println(i);
        }

        System.out.println(sum);
    }

    private static void sumNo7_02(int num, int skip) {

        int sum = 0;

        for (int i = 0; i <= num; i++) {
            if ((i / 7 == 0) && (i % 7 == 0)) {
                continue;
            } else if ((i / 10 == 7) && (i % 7 == 0)) {
                continue;
            } else {
                sum += i;
            }
            System.out.println(i);

        }

        System.out.println(sum);
    }

    // MD5加密方法一
    private static String str2Md5(String origin) {
        String resultString = new String(origin);
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] buf = md.digest(resultString.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(buf);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     MD5加密方法二X

     @author WangYehan
     */
    public static String str2MD5(String str) throws NoSuchAlgorithmException {
        // 获取MD5实例
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        // 更新要解密的字节数组
        md5.update(str.getBytes());
        // MD5加密
        byte[] buffer = md5.digest();
        return byteArr2Str(buffer);

    }

    // 字节数组转换成字符串
    private static String byteArr2Str(byte[] b) {
        // 使用缓冲区：适合对字符串频繁的修改
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            sb.append(b[i]);
        }
        return sb.toString();
    }

    /**
     MD5加密方法三

     @author WangYehan
     */
    private static String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }


    private static String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

    public static String getIdHash(long id) {
        String hash = null;
        long intId = id ^ Long.MAX_VALUE;
        String md5 = String.format("%X-ANY-TEXT", intId);
        try {
            MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] arr = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < arr.length; ++i)
                sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1, 3));

            hash = sb.toString();
        } catch (NoSuchAlgorithmException e) {
        }

        return hash.toUpperCase();
    }
}
