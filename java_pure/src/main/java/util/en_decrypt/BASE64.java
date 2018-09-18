package util.en_decrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import util.IO.FileT;
import util.lang.StringT;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class BASE64 {

    /**
     * 使用jdk的base64 加密字符串
     */
    public static String encrypt(String str) {
        return new BASE64Encoder().encode(str.getBytes());
    }

    /**
     * 使用jdk的base64 解密字符串
     * 返回为null表示解密失败
     */
    public static String decrypt(String str) {
        try {
            String result = new String(new BASE64Decoder().decodeBuffer(str));
            return result;

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


    @Deprecated
    public static String fileToBase64(String filepathame) throws IOException {
        String fileName = filepathame; // 源文件
        String strBase64 = null;
        try {
            InputStream in = new FileInputStream(fileName);
            // in.available()返回文件的字节长度
            byte[] bytes = new byte[in.available()];
            // 将文件中的内容读入到数组中
            in.read(bytes);
            // strBase64 = new BASE64Encoder().encode(bytes); // 将字节流数组转换为字符串
            strBase64 = encrypt(new String(bytes)); // 将字节流数组转换为字符串
            in.close();
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return strBase64;
    }

    @Deprecated
    public static String base64ToFile(String strBase64, String filepath, String filename) throws IOException {
        String string = strBase64;


        new File(filepath).mkdirs();


        String fileName = filepath + filename;// 生成的新文件
        ByteArrayInputStream in = null;
        FileOutputStream out = null;
        try {
            // 解码，然后将字节转换为文件
            // byte[] bytes = new BASE64Decoder().decodeBuffer(string);
            // byte[] bytes = decode(string.trim().replaceAll(" ", ""));
            byte[] bytes = decrypt(string.trim()).getBytes();
            // 将字符串转换为byte数组
            in = new ByteArrayInputStream(bytes);
            byte[] buffer = new byte[1024];
            out = new FileOutputStream(fileName);
            int bytesum = 0;
            int byteread = 0;
            while ((byteread = in.read(buffer)) != -1) {
                bytesum += byteread;
                out.write(buffer, 0, byteread); // 文件写操作
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (out != null)
                out.close();
            if (in != null)
                in.close();
        }
        return fileName;
    }

    public static void main(String[] args) throws IOException {

//        String encrypt = encrypt("我是测试i'm test words--!!@@");
//        String encrypt = encrypt("Hello World");
//        System.out.println(encrypt);
//
//        String decrypt = decrypt(encrypt);
//        System.out.println(decrypt);
//
//        String s = fileToBase64("D:\\下载\\图片\\girl.jpg");
//        System.out.println(encrypt(s));
//
//
//        base64ToFile(encrypt(s), "D:\\", "2.jpg");

//        String filePath = "E:/ok1.png";
//        String imageBinary = getImageBinary(new File(filePath));
//        System.out.println(imageBinary);
//        FileT.write("E:/aaa.txt", imageBinary);
        String read = FileT.read("E:/aaa.txt");
        base64StringToImage(read);

//        base64StringToImage(imageBinary);
    }


    /* --- */
    static BASE64Encoder encoder = new sun.misc.BASE64Encoder();   //加密
    static BASE64Decoder decoder = new sun.misc.BASE64Decoder();   //解密

    private static String getImageBinary(File file) {

        BufferedImage bi;
        try {
            bi = ImageIO.read(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos);
            byte[] bytes = baos.toByteArray();

            return encoder.encodeBuffer(bytes).trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static File base64StringToImage(String base64String) {
        try {
            byte[] bytes1 = decoder.decodeBuffer(base64String);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
            BufferedImage bi1 = ImageIO.read(bais);
            File w2 = new File("E://ok2.png");//可以是jpg,png,gif格式
            ImageIO.write(bi1, "jpg", w2);//不管输出什么格式图片，此处不需改动
            return w2;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
