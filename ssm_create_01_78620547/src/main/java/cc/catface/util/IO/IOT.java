package cc.catface.util.IO;

import java.io.Closeable;
import java.io.IOException;

public class IOT {

    /**
     * close stream
     */
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
