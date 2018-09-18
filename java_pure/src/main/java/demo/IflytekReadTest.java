package demo;

import util.IO.FileT;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class IflytekReadTest {

    public static String cardNo;
    public static String name;
    public static String sex;
    public static String nation;
    public static String birthday;
    public static String addr;
    public static String issue;
    public static String effectiveDate;
    public static String expirationDate;
    public static String idPicPath;
    public static String picPath;

    public static void main(String[] args) throws FileNotFoundException {
//        getInfo("sujiajia2");


        byte[] bytes = new byte[54000];

        bytes = getBytes("C:\\Users\\Administrator\\Desktop\\idcard2.png");
        System.out.println(bytes);


    }


    /**
     * 获得指定文件的byte数组
     */
    public static byte[] getBytes(String filePath) {
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }


    private static void getInfo(String key) {
        try {
            File f = new File("C:\\Users\\Administrator\\Desktop\\cfg.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(key)) {
                    String[] split = line.split(",");
                    cardNo = split[1];
                    name = split[2];
                    sex = split[3];
                    nation = split[4];
                    birthday = split[5];
                    addr = split[6];
                    issue = split[7];
                    effectiveDate = split[8].substring(0, 8);
                    expirationDate = split[8].substring(9);
                    idPicPath = split[9];
                    picPath = split[10];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public static void fileToByte(File img) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            BufferedImage bi;
            bi = ImageIO.read(img);
            ImageIO.write(bi, "jpg", baos);
            bytes = baos.toByteArray();
            System.err.println(bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            baos.close();
        }
    }

    public static byte[] image2byte(String path) {
        byte[] data = null;
        FileImageInputStream input = null;
        try {
            input = new FileImageInputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
        } catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return data;
    }*/
}
