package util.net.http.point_download;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 * -
 * 断点续传:本地无文件从0开始下载 || 本地已有部分文件-->自动读取文件断点并从该点续传
 */
public class PointDownloadT {
    final String TAG = PointDownloadT.class.getSimpleName();

    private static PointDownloadT mInstance;

    public static PointDownloadT getInstance() {
        if (null == mInstance) {
            synchronized (PointDownloadT.class) {
                if (null == mInstance) {
                    mInstance = new PointDownloadT();
                }
            }
        }

        return mInstance;
    }

    public interface Callback {
        void onProgress(long length, long totalLength);

        void onErr();

        void onSuc();
    }

    private void down(String URL, long nPos, String savePathAndFile, Callback callback) {
        try {
            URL url = new URL(URL);
            HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.setRequestProperty("User-Agent", "NetFox");
            httpConnection.setRequestProperty("RANGE", "bytes=" + nPos + "-");
            InputStream input = httpConnection.getInputStream();
            RandomAccessFile oSavedFile = new RandomAccessFile(savePathAndFile, "rw");
            oSavedFile.seek(nPos);
            byte[] b = new byte[4096];  // you can control download speed by modifying this bytes' size
            int nRead;
            while ((nRead = input.read(b, 0, 4096)) > 0) {
                (oSavedFile).write(b, 0, nRead);
                callback.onProgress(oSavedFile.length(), mContentTotalSize);
                sout("总大小|已下载大小|比例-->[" + mContentTotalSize + "]-[" + oSavedFile.length() + "]-[" + (oSavedFile.length() * 100 / mContentTotalSize) + "]");
            }

            httpConnection.disconnect();
            sout("down-->httpConnection.disconnect();");
            if (oSavedFile.length() < mContentTotalSize) {
                callback.onErr();
                sout("下载未完成");
            } else {
                callback.onSuc();
                sout("下载完成");
            }

        } catch (IOException e) {
            callback.onErr();
            sout("down-->exception: " + e.toString());
        }
    }

    long mContentTotalSize = 0;

    private long getRemoteFileSize(String url) {

        try {
            HttpURLConnection conn = (HttpURLConnection) (new URL(url)).openConnection();
            mContentTotalSize = conn.getContentLength();
            conn.disconnect();
        } catch (Exception e) {
            sout("getRemoteFileSize-->eception: " + e.toString());
        }
        return mContentTotalSize;
    }

    public void start(String url, String savePath, String fileName, Callback callback) {
        String repeatFileName = fileName;

        File file = new File(savePath + "/" + fileName);
        long remoteFileSize = getRemoteFileSize(url);
        sout("远程文件大小: " + remoteFileSize);
        int i = 0;
        if (file.exists()) {
            long localFileSize = file.length();
            sout("本地已有文件大小: " + localFileSize);

            if (localFileSize < remoteFileSize) {
                sout("准备进入-->文件续传");
                down(url, localFileSize, savePath + "/" + fileName, callback);
            } else {
                sout("同名文件已存在且完整-->重复下载并自动更换文件名");
                do {
                    i++;
                    fileName = repeatFileName.substring(0, repeatFileName.indexOf(".")) + "(" + i + ")" + repeatFileName.substring(repeatFileName.indexOf("."));

                    file = new File(savePath + "/" + fileName);
                } while (file.exists());
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                down(url, 0, savePath + "/" + fileName, callback);
            }

        } else {
            try {
                file.createNewFile();
                sout("file.createNewFile()-->下载文件");
                down(url, 0, savePath + "/" + fileName, callback);
            } catch (IOException e) {
                sout("start-->exception: " + e.toString());
            }
        }
    }

    private void sout(String msg) {
        System.out.println("wyh  :  " + msg);
    }
}
