package util.en_decrypt;


import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5 {

    private static final boolean SHOW_WITH_16_BIT = false;
    private static final boolean SHOW_WITH_LOWERCASE = true;

    private static final int BUFFER_SIZE = 8 * 1024;

    private static char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static MessageDigest messageDigest = null;

    static {
        try {
            // alternative, you can change to --> "SHA1" | "MD5"
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static String bufferToHex(byte bytes[], int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
        char c0 = hexDigits[(bt & 0xf0) >> 4];
        char c1 = hexDigits[bt & 0xf];
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }

    /**
     convert byte array to string
     */
    private static String bufferToHex(byte bytes[]) {
        String result = bufferToHex(bytes, 0, bytes.length);
        result = SHOW_WITH_16_BIT ? result.substring(8, 24) : result;
        return SHOW_WITH_LOWERCASE ? result.toLowerCase() : result.toUpperCase();
    }

    public static String encryptStr(String str) {
        byte[] inputByteArray = str.getBytes();
        messageDigest.update(inputByteArray);
        byte[] resultByteArray = messageDigest.digest();
        return bufferToHex(resultByteArray);
    }


    public static String encryptFile(String path) {

        FileInputStream fis = null;
        DigestInputStream dis = null;

        try {
            fis = new FileInputStream(path);
            dis = new DigestInputStream(fis, messageDigest);

            byte[] buffer = new byte[BUFFER_SIZE];
            while (dis.read(buffer) > 0) ;

            messageDigest = dis.getMessageDigest();
            byte[] resultByteArray = messageDigest.digest();
            return bufferToHex(resultByteArray);

        } catch (IOException e) {
            e.printStackTrace();
            return "";

        } finally {
            try {
                if (null != dis) dis.close();
                if (null != fis) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String encrypt = encryptFile("D:\\ssm\\download\\mobile_shandong_1.0.1009.apk");
        System.out.println(encrypt);
    }
}