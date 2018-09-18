package util.IO;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */

public class IOT {

    /*** close stream ***/
    public static void close(Closeable closeable) {
        try {
            if (null != closeable) {
                closeable.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
