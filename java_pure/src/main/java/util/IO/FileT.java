package util.IO;

import util.net.LogT;

import java.io.*;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */

public class FileT {
    private static final String TAG = FileT.class.getSimpleName();


    /** 1. 删 - 文件 | 文件夹 */
    public static void delete(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                delete(f.getAbsolutePath());
                f.delete();
            }
        }
        file.delete();
    }


    /*** 2. 增- ***/
    // 1. 自动创建父目录(不覆盖)
    //
    // 2. mkdirs()
    //      1. 目录存在时不创建
    //      2. ("qwer:/asdf")无法创建的目录不创建
    public static void createFile(String path) throws IOException {
        File file = new File(path);
        file.getParentFile().mkdirs();
        file.createNewFile();
    }


    /**** 3. 查 ****/
    // 目录不存在时fileList == null
    static void iterateFolder(File file) {
        File fileList[] = file.listFiles();
        if (fileList == null || fileList.length == 0) return;

        for (File f : fileList) {
            if (f.isDirectory()) {
                LogT.d(TAG, "iterateFolder-->is folder: " + f.getAbsolutePath());
                iterateFolder(f);
            } else {
                LogT.d(TAG, "iterateFolder-->is file: " + f.getAbsolutePath());
            }
        }
    }


    /*** 4. 复制- ***/
    // 默认会覆盖内容
    public static void copyFile(String oldPath, String newPath, boolean notOverwrite) {
        InputStream is = null;
        FileOutputStream fos = null;    // FileOutputStream[文件不存在时自动创建]

        try {
            File oldFile = new File(oldPath);
            File newFile = new File(newPath);

            if (notOverwrite && newFile.exists()) return;

            if (!oldFile.exists()) return;
            newFile.getParentFile().mkdirs();

            is = new FileInputStream(oldPath);
            fos = new FileOutputStream(newFile);

            byte[] buffer = new byte[1024 * 2];
            int length;
            while ((length = is.read(buffer)) != -1) {
                fos.write(buffer, 0, length);
            }

        } catch (Exception e) {
            LogT.d(TAG, "copyFile-->exception: " + e.toString());

        } finally {
            try {
                if (null != fos) fos.close();
                if (null != is) is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void copyFolder(String oldDir, String newDir) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {

            new File(newDir).mkdirs();
            String[] files = new File(oldDir).list();
            if (null == files) return;
            File temp;

            for (int i = 0; i < files.length; i++) {
                if (oldDir.endsWith(File.separator)) {
                    temp = new File(oldDir + files[i]);
                } else {
                    temp = new File(oldDir + File.separator + files[i]);
                }

                if (temp.isFile()) {
                    fis = new FileInputStream(temp);
                    fos = new FileOutputStream(newDir + "/" + (temp.getName()));
                    byte[] b = new byte[1024 * 2];
                    int len;
                    while ((len = fis.read(b)) != -1) {
                        fos.write(b, 0, len);
                    }
                }

                if (temp.isDirectory()) {
                    copyFolder(oldDir + "/" + files[i], newDir + "/" + files[i]);
                }
            }

        } catch (Exception e) {
            LogT.d(TAG, "copyFolder-->exception: " + e.toString());

        } finally {
            try {
                if (null != fos) fos.close();
                if (null != fis) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /*** 6. 转- ***/
    public static byte[] getBytes(String path) {
        byte[] bytes = null;

        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
            byte[] buffer = new byte[1024];
            int n;
            while ((n = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, n);
            }
            fis.close();
            bos.close();
            bytes = bos.toByteArray();

        } catch (IOException e) {
            LogT.d(TAG, "getBytes-->exception: " + e.toString());
        }

        return bytes;
    }


    public static void getFile(byte[] bytes, String path) {    // 默认会覆盖
        BufferedOutputStream os = null;
        try {
            File file = new File(path);
            file.getParentFile().mkdirs();

            os = new BufferedOutputStream(new FileOutputStream(file));
            os.write(bytes);

        } catch (IOException e) {
            LogT.d(TAG, "getFile-->exception: " + e.toString());
        } finally {
            try {
                if (null != os) os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /*** 读文本- ***/
    public static String suffix(String path) {
        File file = new File(path);
        return file.exists() && file.isFile() ? path.substring(path.lastIndexOf(".") + 1) : "";
    }


    public static String read(String path) {
        StringBuilder content = new StringBuilder();

        File file = new File(path);
        BufferedReader br = null;

        if (!file.exists() || !file.isFile()) return "";

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\r\n");
            }

        } catch (IOException e) {
            LogT.d(TAG, "read-->exception: " + e.toString());
        } finally {
            try {
                if (null != br) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return content.toString();
    }


    /*** 写文本- ***/
    public static void write(String filePath, String content) {
        write(filePath, content, false);
    }

    public static void write(String filePath, String content, boolean isAppend) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filePath, isAppend));
            bw.write(content);

        } catch (Exception e) {
            LogT.d(TAG, "write-->exception: " + e.toString());

        } finally {
            try {
                if (null != bw) bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        iterateFolder(new File("e:/afasg"));

    }
}
