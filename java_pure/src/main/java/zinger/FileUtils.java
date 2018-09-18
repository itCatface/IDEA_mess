//package zinger;
//
//import sun.rmi.runtime.Log;
//
//import java.io.*;
//import java.math.BigInteger;
//import java.security.MessageDigest;
//import java.util.Enumeration;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipException;
//import java.util.zip.ZipFile;
//
//public class FileUtils {
//    private static final String TAG = "FileUtils";
//    public static final int TYPE_EXCEPTION = 2;
//    public static final int TYPE_FILE_NOEXIST = 0;
//    public static final int TYPE_LOW_MEMORY = 1;
//    public static final int TYPE_NO_MUSIC_FILE = 3;
//
//    public interface CopyMusicLinstener {
//        void error(int i, String str);
//
//        void finishCopy();
//
//        void startCopy();
//    }
//
//    public static boolean deleteFile(File file) {
//        if (file == null) {
//            CommCenterLog.e(TAG, "file == null");
//        }
//        if (!file.exists()) {
//            CommCenterLog.e(TAG, file.getAbsolutePath() + " is no exists");
//        } else if (file.isFile()) {
//            return file.delete();
//        } else {
//            if (file.isDirectory()) {
//                File[] childFile = file.listFiles();
//                if (childFile == null || childFile.length == 0) {
//                    return file.delete();
//                }
//                for (File f : childFile) {
//                    deleteFile(f);
//                }
//                return file.delete();
//            }
//            CommCenterLog.e(TAG, file.getAbsolutePath() + " is no file");
//        }
//        return false;
//    }
//
//    public static boolean deleteBaiduNaviDirectory(File file) {
//        if (!file.exists() || !file.isDirectory()) {
//            return false;
//        }
//        for (File f : file.listFiles()) {
//            if (f.exists()) {
//                f.delete();
//            }
//        }
//        file.delete();
//        return true;
//    }
//
//    public static String getFileMD5(File file) {
//        Exception e;
//        if (!file.isFile()) {
//            return null;
//        }
//        byte[] buffer = new byte[1024];
//        try {
//            MessageDigest digest = MessageDigest.getInstance("MD5");
//            FileInputStream in = new FileInputStream(file);
//            while (true) {
//                try {
//                    int len = in.read(buffer, 0, 1024);
//                    if (len != -1) {
//                        digest.update(buffer, 0, len);
//                    } else {
//                        in.close();
//                        return new BigInteger(1, digest.digest()).toString(16);
//                    }
//                } catch (Exception e2) {
//                    e = e2;
//                    FileInputStream fileInputStream = in;
//                }
//            }
//        } catch (Exception e3) {
//            e = e3;
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public static int upZipFile(String zipFileName, String folderPath) throws ZipException, IOException {
//        File zipFile = new File(zipFileName);
//        if (zipFile.exists()) {
//            ZipFile zfile = new ZipFile(zipFile);
//            Enumeration zList = zfile.entries();
//            byte[] buf = new byte[1024];
//            while (zList.hasMoreElements()) {
//                ZipEntry ze = (ZipEntry) zList.nextElement();
//                if (ze.isDirectory()) {
//                    CommCenterLog.d("upZipFile", "directory ze.getName() = " + ze.getName());
//                    String dirstr = folderPath + ze.getName();
//                    CommCenterLog.d("upZipFile", "str = " + dirstr);
//                    new File(dirstr).mkdir();
//                } else {
//                    CommCenterLog.d("upZipFile", "ze.getName() = " + ze.getName());
//                    OutputStream os = new BufferedOutputStream(new FileOutputStream(getRealFileName(folderPath, ze.getName())));
//                    InputStream is = new BufferedInputStream(zfile.getInputStream(ze));
//                    while (true) {
//                        int readLen = is.read(buf, 0, 1024);
//                        if (readLen == -1) {
//                            break;
//                        }
//                        os.write(buf, 0, readLen);
//                    }
//                    is.close();
//                    os.close();
//                }
//            }
//            zfile.close();
//            CommCenterLog.d("upZipFile", "upZipFile finish");
//            return 0;
//        }
//        CommCenterLog.e("upZipFile", zipFileName + " is noexists");
//        return -1;
//    }
//
//    public static File getRealFileName(String baseDir, String absFileName) {
//        String[] dirs = absFileName.split("/");
//        File ret = new File(baseDir);
//        if (dirs.length <= 1) {
//            return ret;
//        }
//        int i = 0;
//        while (i < dirs.length - 1) {
//            i++;
//            ret = new File(ret, dirs[i]);
//        }
//        CommCenterLog.d("upZipFile", "1ret = " + ret);
//        if (!ret.exists()) {
//            ret.mkdirs();
//        }
//        File ret2 = new File(ret, dirs[dirs.length - 1]);
//        CommCenterLog.d("upZipFile", "2ret = " + ret2);
//        ret = ret2;
//        return ret2;
//    }
//
//    public static String makeMapZipsDir() {
//        String path = Utils.getSDRoot() + "/zinger/BaiduZip";
//        File f = new File(path);
//        if (!(f == null || f.exists())) {
//            f.mkdir();
//        }
//        return path;
//    }
//
//    public static String makeUpdateZipsDir() {
//        String path = Utils.getSDRoot() + "/zinger/updateZip";
//        File f = new File(path);
//        if (!(f == null || f.exists())) {
//            f.mkdir();
//        }
//        return path;
//    }
//
//    public static String makeMusicDir() {
//        String path = Utils.getSDRoot();
//        if (path == null) {
//            return null;
//        }
//        path = path + "/zinger/music";
//        File f = new File(path);
//        if (f == null || f.exists()) {
//            return path;
//        }
//        f.mkdir();
//        return path;
//    }
//
//    public static String getSettingsFilePath() {
//        String path = Utils.getSDRoot();
//        if (path == null) {
//            return null;
//        }
//        path = path + "/zinger/settings";
//        File f = new File(path);
//        if (!(f == null || f.exists())) {
//            f.mkdir();
//        }
//        return path + File.separator + "settings.prop";
//    }
//
//    public static String getWearningPhotoPath() {
//        String path = Utils.getSDRoot();
//        if (path == null) {
//            return null;
//        }
//        path = path + "/zinger/wearningPhoto";
//        File f = new File(path);
//        if (f == null || f.exists()) {
//            return path;
//        }
//        f.mkdir();
//        return path;
//    }
//
//    public static String makeBaiduNaviDir(int type) {
//        String path = Utils.getSDRoot() + "/BaiduNaviSDK";
//        if (type == 0) {
//            path = path + "/bnav/navi";
//        } else if (type == 1) {
//            path = path + "/bnav/vmp/h";
//        }
//        File f = new File(path);
//        if (!(f == null || f.exists())) {
//            f.mkdir();
//        }
//        return path;
//    }
//
//    public static String makeWeChatDir() {
//        String path = Utils.getSDRoot();
//        if (path == null) {
//            return null;
//        }
//        path = path + "/zinger/wechat";
//        File f = new File(path);
//        if (f == null || f.exists()) {
//            return path;
//        }
//        f.mkdir();
//        return path;
//    }
//
//    public static boolean unZip(String zipPath, String toPath) {
//        File file;
//        try {
//            ZipFile zip = new ZipFile(zipPath);
//            String Parent = toPath;
//            Enumeration<? extends ZipEntry> entrys = zip.entries();
//            if (entrys != null) {
//                File Fout;
//                File Fout2 = null;
//                while (entrys.hasMoreElements()) {
//                    try {
//                        ZipEntry entry = (ZipEntry) entrys.nextElement();
//                        if (entry != null) {
//                            Fout = new File(Parent, entry.getName());
//                            System.out.println(Fout.getPath() + " 正在解压");
//                            if (entry.isDirectory()) {
//                                Fout.mkdirs();
//                                Fout2 = Fout;
//                            } else {
//                                FileOutputStream out = new FileOutputStream(Fout);
//                                BufferedOutputStream Bout = new BufferedOutputStream(out);
//                                InputStream in = zip.getInputStream(entry);
//                                while (true) {
//                                    int b = in.read();
//                                    if (b != -1) {
//                                        Bout.write(b);
//                                    } else {
//                                        try {
//                                            break;
//                                        } catch (Exception e) {
//                                        }
//                                    }
//                                }
//                                Bout.flush();
//                                Bout.close();
//                                out.close();
//                                in.close();
//                                System.out.println(Fout + "解压成功");
//                                Fout2 = Fout;
//                            }
//                        }
//                    } catch (Exception e2) {
//                        Fout = Fout2;
//                    }
//                }
//                Fout = Fout2;
//            }
//            return true;
//            file = new File(System.getenv("EXTERNAL_STORAGE") + "/zinger/updateZip", "mcu.zip");
//            Log.i(TAG, "unZip111 delete updateZip mcu.zip");
//            deleteFile(file);
//            return false;
//        } catch (Exception e3) {
//            file = new File(System.getenv("EXTERNAL_STORAGE") + "/zinger/updateZip", "mcu.zip");
//            Log.i(TAG, "unZip222 delete updateZip mcu.zip");
//            deleteFile(file);
//            return false;
//        }
//    }
//
//    public static void copyMusic(final String oldPath, final CopyMusicLinstener listener) {
//        new Thread(new Runnable() {
//            public void run() {
//                try {
//                    if (listener != null) {
//                        listener.startCopy();
//                    }
//                    File a = new File(oldPath);
//                    if (a.exists()) {
//                        String musicPath = FileUtils.makeMusicDir();
//                        File[] file = a.listFiles(new FilenameFilter() {
//                            public boolean accept(File f, String filename) {
//                                String filenameLower = filename.toLowerCase();
//                                return filenameLower.endsWith(".mp3") || filenameLower.endsWith(".wav") || filenameLower.endsWith(".aac") || filenameLower.endsWith(".ogg");
//                            }
//                        });
//                        if (file.length > 0) {
//                            int i = 0;
//                            while (i < file.length) {
//                                File temp = file[i];
//                                CommCenterLog.e(FileUtils.TAG, temp.getName());
//                                if (FileUtils.getSDCardSpace() > temp.length()) {
//                                    FileInputStream input = new FileInputStream(temp);
//                                    FileOutputStream output = new FileOutputStream(musicPath + "/" + temp.getName().toString());
//                                    byte[] b = new byte[5120];
//                                    while (true) {
//                                        int len = input.read(b);
//                                        if (len == -1) {
//                                            break;
//                                        }
//                                        output.write(b, 0, len);
//                                    }
//                                    output.flush();
//                                    output.close();
//                                    input.close();
//                                    CommCenterLog.e(FileUtils.TAG, "delete = " + temp.delete());
//                                    if (i == file.length - 1 && listener != null) {
//                                        listener.finishCopy();
//                                    }
//                                    i++;
//                                } else {
//                                    CommCenterLog.e(FileUtils.TAG, "磁盘空间不足");
//                                    if (listener != null) {
//                                        listener.error(1, "磁盘空间不足");
//                                        return;
//                                    }
//                                    return;
//                                }
//                            }
//                            return;
//                        } else if (listener != null) {
//                            listener.error(3, "没有音乐文件");
//                            return;
//                        } else {
//                            return;
//                        }
//                    }
//                    CommCenterLog.e(FileUtils.TAG, "文件不存在");
//                    if (listener != null) {
//                        listener.error(0, "文件不存在");
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    CommCenterLog.e(FileUtils.TAG, "copyMusic error");
//                    if (listener != null) {
//                        listener.error(2, "拷贝异常");
//                    }
//                }
//            }
//        }).start();
//    }
//
//    public static void copyFile(String oldPath, String newPath) {
//        int bytesum = 0;
//        try {
//            if (new File(oldPath).exists()) {
//                InputStream inStream = new FileInputStream(oldPath);
//                FileOutputStream fs = new FileOutputStream(newPath);
//                byte[] buffer = new byte[1444];
//                while (true) {
//                    int byteread = inStream.read(buffer);
//                    if (byteread != -1) {
//                        bytesum += byteread;
//                        System.out.println(bytesum);
//                        fs.write(buffer, 0, byteread);
//                    } else {
//                        inStream.close();
//                        return;
//                    }
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("复制单个文件操作出错");
//            e.printStackTrace();
//        }
//    }
//
//    public static void copyFolder(String oldPath, String newPath) {
//        try {
//            new File(newPath).mkdirs();
//            String[] file = new File(oldPath).list();
//            for (int i = 0; i < file.length; i++) {
//                File temp;
//                if (oldPath.endsWith(File.separator)) {
//                    temp = new File(oldPath + file[i]);
//                } else {
//                    temp = new File(oldPath + File.separator + file[i]);
//                }
//                if (temp.isFile()) {
//                    FileInputStream input = new FileInputStream(temp);
//                    FileOutputStream output = new FileOutputStream(newPath + "/" + temp.getName().toString());
//                    byte[] b = new byte[5120];
//                    while (true) {
//                        int len = input.read(b);
//                        if (len == -1) {
//                            break;
//                        }
//                        output.write(b, 0, len);
//                    }
//                    output.flush();
//                    output.close();
//                    input.close();
//                }
//                if (temp.isDirectory()) {
//                    copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
//                }
//            }
//        } catch (Exception e) {
//            Log.i(TAG, "复制整个文件夹内容操作出错 e:" + e);
//            e.printStackTrace();
//        }
//    }
//
//    public static long getSDCardSpace() {
//        String path = Utils.getSDRoot();
//        if (TextUtils.isEmpty(path)) {
//            return -1;
//        }
//        return new File(path).getFreeSpace();
//    }
//}