package iflytek;

import java.io.File;

/**
 * Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */

public class EncryptUtil {

    private static EncryptUtil mInstance;
    public static EncryptUtil getInstance() {
        EncryptUtil instance = mInstance;
        if (null == instance) {
            synchronized (EncryptUtil.class) {
                instance = mInstance;
                if (null == instance) {
                    instance = new EncryptUtil();
                    mInstance = instance;
                }
            }
        }

        return instance;
    }


    public void encrypt(String... filePaths) {
        for (String filePath : filePaths) {
            File file = new File(filePath);
            if (!file.exists() || !file.isFile()) continue;

            XOR.encrypt(filePath, filePath + "_copy");
            file.delete();
            XOR.renameFile(filePath + "_copy", filePath.substring(0, filePath.lastIndexOf(".")));
        }
    }

}
