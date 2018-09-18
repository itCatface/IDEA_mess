package util.lang;


import java.io.*;

public class ObjectT {

    /**
     * object -> byte array
     */
    public static byte[] toByte(Object object) {

        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;

        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);

            return baos.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
            return null;

        } finally {
            try {
                if (null != oos) oos.close();
                if (null != baos) baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * byte array -> object
     */
    public static Object toObj(byte[] bytes) {

        ObjectInputStream ois = null;

        try {
            Object object = null;
            ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
            object = ois.readObject();

            return object;

        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } finally {
            try {
                if (null != ois) ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
