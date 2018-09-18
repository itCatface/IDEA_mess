package request;

import com.ist.manage.utils.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class AESUtil {
    //算法参数  16字节
    private static final String IV = "~e#$1-+=@%^&*(w)";
    private static final String CHARSET = "UTF-8";
    private static final String ALGORITHM = "AES";

    public final static String TRANSFER_SEED = "esWES65d181GJarv";  //加密seed
    public final static String TRANSFER_KEY = "esbcf4laWE9pfesb";  //加密key
    /**
     * 算法/模式/填充
     **/
    private static final String CIPHER_MODE = "AES/CBC/PKCS5Padding";

    /**
     * 加密
     *
     * @param seed      用户口令，长度固定为16字节（16个英文字符）
     * @param cleartext 明文
     * @return 密文
     * @throws Exception
     */
    public static String encrypt(String seed, String cleartext)
            throws Exception {
        IvParameterSpec zeroIv = new IvParameterSpec(IV.getBytes(CHARSET));
        SecretKeySpec key = new SecretKeySpec(seed.getBytes(CHARSET), ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER_MODE);
        cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
        byte[] encryptedData = cipher.doFinal(cleartext.getBytes(CHARSET));

        return Base64.encodeBytes(encryptedData);
    }

    public static byte[] encrypt(String seed, byte[] source)
            throws Exception {
        IvParameterSpec zeroIv = new IvParameterSpec(IV.getBytes(CHARSET));
        SecretKeySpec key = new SecretKeySpec(seed.getBytes(CHARSET), ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER_MODE);
        cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
        byte[] encryptedData = cipher.doFinal(source);

        return Base64.encodeBytesToBytes(encryptedData);
    }

    /**
     * 解密
     *
     * @param seed      用户口令，长度固定为16字节（16个英文字符）
     * @param encrypted 密文
     * @return 明文
     * @throws Exception
     */
    public static String decrypt(String seed, String encrypted) throws Exception {

        if (encrypted.startsWith("\"") && encrypted.endsWith("\"")) {
            System.out.println("删除前后双引号");
            encrypted = encrypted.substring(1, encrypted.length() - 1);
        }


        byte[] byteMi = Base64.decode(encrypted);
        IvParameterSpec zeroIv = new IvParameterSpec(IV.getBytes(CHARSET));
        SecretKeySpec key = new SecretKeySpec(seed.getBytes(CHARSET), ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER_MODE);
        cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
        byte[] decryptedData = cipher.doFinal(byteMi);

        return new String(decryptedData, CHARSET);
    }

    public static byte[] decrypt(String seed, byte[] encrypted)
            throws Exception {
        byte[] byteMi = Base64.decode(encrypted);
        IvParameterSpec zeroIv = new IvParameterSpec(IV.getBytes(CHARSET));
        SecretKeySpec key = new SecretKeySpec(seed.getBytes(CHARSET), ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER_MODE);
        cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
        byte[] decryptedData = cipher.doFinal(byteMi);

        return decryptedData;
    }



    /*******from android*/
    // MD5加密
    public static String toMd5(byte[] bytes) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(bytes);

            return toHexString(algorithm.digest());
//			return toHexString(algorithm.digest(), "");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toHexString(byte[] buffer) {
        StringBuffer sb = new StringBuffer();
        String s = null;
        for (int i = 0; i < buffer.length; i++) {
            s = Integer.toHexString(buffer[i] & 0xff);
            System.out.println(s);
            if (s.length() < 2)
                sb.append('0');
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String s = "PYsHtHyM9UScO2cQQGik9+YEua7kpB5KW1jUvLqNhRVrORu3eWhCdFb2/jZTToRgyjf8G26dG/xIqTfEL8L9iSXMMfZZ8Lb3bQyVd/+sOx6M8XqTVuwQ3i99vkN36Qs3ZRlc0/xQ5crevA8Kg56iHjiP5cK+3lXRZ2B2L8HPJMc=";

        s = "aN4VXw9hBb64PkVpDbmM9uqHLt1SZXgkAMzcLccfG7ypHNAJAkuic2gidReScST+cXt0kge3bU6d+i+lWtMgmw==";


        s = "kZEkvp1rlLfiFkvlK0jStA==";

        s = "k4I5OL73e2p9CZamNKhh9jI1wFoq6Kic2geQkP8Ns3iHhOfrDPW/ike407Q6amIv/4UIOFhpCyR7jbLgbJLZR9ut/q0OSL+CKNUk/2hOl0o+eU5TfSpwWkjghwnnRWidFX7Rqhl2+ngVxQPYszzEVok+LpvJM0hCdh9SuxcxshI20UO3IFqz7b/pqyHeGycn2SRgfvc15m+byaAQB0ZJlCQiTApXonC0aCPfx1M/bUJni+JufPV603zqD04VmKZ+NRMSKt2FEX13kJ/bgO7iGvwwNM9QgIviuJENUksdtSVvoO30woL1Ra2Uc5oYhJnvsLkayOqcxmUMtOxgZNDJ4W8H93A1nUcY8+91JkPyHFiBYsJCuQN1XNdAy4g/0UevnONGtUYUR91dHToFpaldETEMxCGFtStGzQWV+489gk6XuKwHJsA1ila36dg72nzlEvGE7b4q4F9Od4quJ63gkA==";
        s = "hW7aYf0X4m8BrBZuEaBCTRoqqJlpLIExiZEDWX37X+Q4+6g3MAPwv5cLKw20vu0GFu9aazLa9w6bFrRXUppUWMZvUXIHaWC2p44l6YFeZUITvgktUp6hVldSsvQoXhe4x1tlb/TZVDcplqlsbqKFPA==/IuyeaH0zlzlq3ejJLwIT8q2km5WcwjOWQrgEEsa7UbaaTH+5zaVWHGXaP8xF3ReNNO1PcSDvHAdjvv5iMVIJ5GUOknaG0KWeiwwneUQmIQqkv62efgRZeKXcIcpmT3wIk0v9tOZOBzm+yufdo9Sn6hdQLA9Nh5bN3mL+YFiFQnLmXtx5R2S/TszaPgplgl4RGH5DwAYxF9NLm2sXHRQ==";


        s = "TE4Zp+SCkrCIRqD2VgVb3f9N6cwbYfHr7wsHXy2C7Y6q1wDFHjuZV5ZBAYV/Dxifs7otr/KZHFJMDxp71jHZ/Hlegw4eHtLYUTkFQFjga6GihBJmHDj6E45ITkB/woajo4IsfGLTNRip3DncKSEwvjbWNBhgwaVlJf5jd/y7L0d6XQkzbonzoqzY43rsVz0liyhW6BeHxTAvFPt5bncmbujn7t7fuKBVq0S/NoVK0Gq8lazjsEc0Mm4icrXINWnl";
//        s = "NyEPGABYKGgxtXqdJrG3KNzpLI/8jmfiCzXwwgWrMYOzgU6byPPCQP6xmRuPIs6IBOhNNJigS9tOsEDzgK05FyH6vEUuvEueD9nNPuhzl02a3dIdy68Lu6jmqn+12/RmmjXZ+yegu8EhMJBiAdhJXSTsscX1LGC5n5nMWOlcsz+q+BF1z/0d88M2Aqk5nMYTK+/lYTMjDJVEx80/fmHhwiHIfvDVQuk2siY3k3ejDk5VsxGY8mhx9PvXIO6l5mIv";
//        s = "NyEPGABYKGgxtXqdJrG3KNzpLI/8jmfiCzXwwgWrMYOzgU6byPPCQP6xmRuPIs6IBOhNNJigS9tOsEDzgK05FyH6vEUuvEueD9nNPuhzl02a3dIdy68Lu6jmqn+12/RmmjXZ+yegu8EhMJBiAdhJXSTsscX1LGC5n5nMWOlcsz+q+BF1z/0d88M2Aqk5nMYTK+/lYTMjDJVEx80/fmHhwiHIfvDVQuk2siY3k3ejDk5VsxGY8mhx9PvXIO6l5mIv";
//        s = "q+iE0huhWeH6SwV3KcBHuiaPuRfhawob+02/syN1siV+sL808JH37B8y28gQc8BDhfYuCm2R0Y1Xs0mh4+vkQeX1fEb9epvciGNoY+nmjzj3P49P0BeDBZl3dTtwNAPXcyzajE7SzBExXIkfc7427A==";
//        s = "TE4Zp+SCkrCIRqD2VgVb3f9N6cwbYfHr7wsHXy2C7Y47aiIQa8fRdSd1EEquumcRkWw8DM5jCXqmG9clnSDwuafju4NaNvaOIM29JXUJWD7fheAj61CCabZ1UUKN53qAVJ730kuabNILEl4EV7ra73nKcnUmrcDwhempz4tyL4hoWMsj6zATrb7sSnVaW7BP28tFfrx6+MMBRvphdN2+TQ==";
//        s = "vRdk5UvvtsHmDN2XxODr+5iOG0/N14B3D9uyPmRyHNW8VIh5M2aH8gpdafYMD0/ClzOlP16drUolgjndff9i/8RhW+dxSS5hXqrzj0WTeEg=";

//        s = "vRdk5UvvtsHmDN2XxODr+54v68Ni6EvPfpF5weZSnxI9nsqNsoE2ibbfQa6C313IKwOiUl/PsJNSZxBIhaedmnDM+F0RREzu9dYJCTDwQDwkhP9TVHkFCi/JPYmgGOOm";

        try {
//            System.out.println(encrypt(TRANSFER_SEED, ""));

            System.out.println(decrypt(TRANSFER_SEED, s));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
