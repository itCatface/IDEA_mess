package iflytek;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XOR {

    // key's of xor encrypt
    public static final int XOR_CONST = 0X99;
    private static final String TAG = XOR.class.getSimpleName();


    public static String encrypt(String str) {
        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            charArr[i] = (char) (charArr[i] ^ 0X99);
        }

        return new String(charArr);
    }


    public static void encrypt(String srcPath, String desPath) {

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File srcFile = new File(srcPath);
            File desFile = new File(desPath);

            if (!srcFile.exists()) return;

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile);

            int read;
            while ((read = fis.read()) > -1) {
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

    /** 文件重命名
     * @param oldPath  原来的文件路径
     * @param newPath 新文件路径
     */
    public static void renameFile(String oldPath,String newPath) {
        if(!oldPath.equals(newPath)){//新的文件名和以前文件名不同时,才有必要进行重命名
            File oldfile=new File(oldPath);
            File newfile=new File(newPath);
            if(!oldfile.exists()){
                return;//重命名文件不存在
            }
            if(newfile.exists()) {//若在该目录下已经有一个文件和新文件名相同，则不允许重命名
                return;
            } else {
                oldfile.renameTo(newfile);
            }
        }else{
            return;
        }
    }

}
