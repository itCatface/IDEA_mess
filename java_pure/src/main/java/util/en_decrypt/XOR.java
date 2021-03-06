package util.en_decrypt;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XOR {

    // key's of xor encrypt
    public static final int XOR_CONST = 0X99;


    public static String encrypt(String str) {
        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            charArr[i] = (char) (charArr[i] ^ 0X99);
        }

        return new String(charArr);
    }


    public static void encrypt(String srcPath, boolean isFile) {
        try {
            encrypt(srcPath, srcPath + "qwerdf1234");
            new File(srcPath).deleteOnExit();
            new File(srcPath).createNewFile();
            boolean b = new File(srcPath + "qwerdf1234").renameTo(new File(srcPath));
            System.out.println(b);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void encrypt(String srcPath, String desPath) {

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File srcFile = new File(srcPath);
            File desFile = new File(desPath);

            if (!srcFile.exists()) throw new RuntimeException("src file dose not exist!");

            fis = new FileInputStream(srcFile);

            fos = new FileOutputStream(desFile);

            int read;
            while ((read = fis.read()) > -1) {
                System.out.print(read);
                fos.write(read ^ XOR_CONST);
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (null != fos) fos.close();
                if (null != fis) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
