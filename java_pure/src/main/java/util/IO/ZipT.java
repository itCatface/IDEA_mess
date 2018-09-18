package util.IO;


import util.net.LogT;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */

public final class ZipT {
    static final String TAG = ZipT.class.getSimpleName();

    public static final boolean ZIP_REMAIN_ROOT_DIR = true;
    public static final boolean ZIP_REMOVE_ROOT_DIR = false;


    /*** 压缩目录- ***/
    public static void zip(File srcFile, File desFile) {
        zip(srcFile, desFile, true);
    }

    public static void zip(File srcFile, File desFile, boolean keepRootDir) {
        ZipOutputStream zos;

        if (!srcFile.exists()) {
            LogT.d(TAG, "zip-->源文件不存在...");
            return;
        }

        try {
            zos = new ZipOutputStream(new FileOutputStream(desFile));
            if (srcFile.isDirectory()) {
                File[] files = srcFile.listFiles();
                for (File fileSec : files) {
                    if (keepRootDir) {
                        recursionZip(zos, fileSec, srcFile.getName() + "/");

                    } else {
                        recursionZip(zos, fileSec, "");
                    }
                }
            }
            zos.close();

        } catch (Exception e) {
            LogT.d(TAG, "zip-->exception: " + e.toString());
        }
    }

    private static void recursionZip(ZipOutputStream zos, File file, String rootDir) {
        try {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File fileSec : files) {
                    recursionZip(zos, fileSec, rootDir + file.getName() + "/");
                }

            } else {
                byte[] buf = new byte[1024];
                InputStream is = new FileInputStream(file);
                zos.putNextEntry(new ZipEntry(rootDir + file.getName()));
                int len;
                while ((len = is.read(buf)) != -1) {
                    zos.write(buf, 0, len);
                }

                is.close();
            }

        } catch (IOException e) {
            LogT.d(TAG, "recursionZip-->exception: " + e.toString());
        }
    }


    /*** 压缩多个文件- ***/
    public static void zipFiles(File desZipFile, String rootName, File... srcFiles) {
        if (!desZipFile.getParentFile().exists()) desZipFile.getParentFile().mkdirs();  // 自动创建父目录
        ZipOutputStream zos = null;

        try {
            zos = new ZipOutputStream(new FileOutputStream(desZipFile));
            zipFiles(zos, rootName, srcFiles);
            zos.close();

        } catch (IOException e) {
            LogT.d(TAG, "zipFiles-->exception: " + e.toString());

        } finally {
            try {
                if (null != zos) zos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void zipFiles(ZipOutputStream zos, String rootName, File... srcFiles) {
        rootName = rootName.replaceAll("\\*", "/");
        if (!rootName.endsWith("/")) rootName += "/";
        byte[] buffer = new byte[1024];
        try {
            for (int i = 0; i < srcFiles.length; i++) {
                if (!srcFiles[i].exists()) {
                    LogT.d(TAG, "zipFiles-->该源文件不存: " + srcFiles[i].getAbsolutePath());
                    continue;
                }

                if (srcFiles[i].isDirectory()) {
                    File[] files = srcFiles[i].listFiles();
                    String srcPath = srcFiles[i].getName();

                    srcPath = srcPath.replaceAll("\\*", "/");
                    if (!srcPath.endsWith("/")) srcPath += "/";

                    zos.putNextEntry(new ZipEntry(rootName + srcPath));
                    zipFiles(zos, rootName + srcPath, files);

                } else {
                    FileInputStream in = new FileInputStream(srcFiles[i]);
                    zos.putNextEntry(new ZipEntry(rootName + srcFiles[i].getName()));

                    int len;
                    while ((len = in.read(buffer)) > 0) {
                        zos.write(buffer, 0, len);
                    }

                    zos.closeEntry();
                    in.close();
                }
            }
        } catch (Exception e) {
            LogT.d(TAG, "zipFiles-->exception: " + e.toString());
        }
    }


    /*** 解压- ***/
    @SuppressWarnings("rawtypes")
    public static void unZip(String zipPath, String descDir) {
        File zipFile = new File(zipPath);
        if (!zipFile.exists()) throw new RuntimeException("zip file does not exist!");

        File desDirFile = new File(descDir);
        if (!desDirFile.exists()) desDirFile.mkdirs();

        InputStream is = null;
        OutputStream os = null;

        try {
            // use "GBK" to avoid no name mystery exceptions
            ZipFile zip = new ZipFile(zipFile, Charset.forName("GBK"));

            for (Enumeration entries = zip.entries(); entries.hasMoreElements(); ) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                String zipEntryName = entry.getName();
                is = zip.getInputStream(entry);
                //                String outPath = (descDir + zipEntryName).replaceAll("\\*", "/");
                String outPath = (descDir + "/" + zipEntryName).replaceAll("\\*", "/");

                File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
                if (!file.exists()) file.mkdirs();

                if (new File(outPath).isDirectory()) continue;

                os = new FileOutputStream(outPath);
                byte[] buffer = new byte[1024];
                int len;
                while ((len = is.read(buffer)) > 0) {
                    os.write(buffer, 0, len);
                }
            }

        } catch (IOException e) {
            LogT.d(TAG, "unZip-->exception: " + e.toString());

        } finally {
            try {
                if (null != os) os.close();
                if (null != is) is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}