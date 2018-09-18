package net;

import okhttp3.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wyh
 *
 * @desc you can getInstance the progress of real time in downloading process
 */

public class DownLoadT {

    private static DownLoadT mInstance;
    private final OkHttpClient okHttpClient;


    /**
     * getInstance OkHttpClient by using or not using single instance
     */
    public static DownLoadT getInstance() {
        if (null == mInstance) {
            synchronized (DownLoadT.class) {
                if (null == mInstance) mInstance = new DownLoadT();
            }

        }

        return mInstance;
    }

    private DownLoadT() {
        okHttpClient = new OkHttpClient();
    }


    /**
     * @desc download file with process listener
     */
    public void download(final String url, final String saveDir, final OnDownloadListener listener) {
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                listener.onErr(e.toString());
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                InputStream is = null;
                byte[] buf = new byte[4096];
                int len = 0;
                FileOutputStream fos = null;

                String savePath = isExistDir(saveDir); // the dir of the file
                try {
                    is = response.body().byteStream();
                    long total = response.body().contentLength();
                    File file = new File(savePath, getNameFromUrl(url));
                    fos = new FileOutputStream(file);
                    long sum = 0;
                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                        sum += len;
                        int progress = (int) (sum * 1.0f / total * 100);

                        listener.onProgress(progress); // download progress
                    }
                    fos.flush();

                    listener.onSuc(); // download completed

                } catch (Exception e) {
                    listener.onErr(e.toString());

                } finally {
                    try {
                        if (is != null) is.close();
                        if (fos != null) fos.close();
                    } catch (IOException e) {
                        listener.onErr(e.toString());
                    }
                }
            }
        });
    }


    /**
     * check the dir is exists
     */
    private String isExistDir(String saveDir) throws IOException {

        File downloadFile = new File(saveDir);
        if (!downloadFile.mkdirs()) {
            downloadFile.createNewFile();
        }
        String savePath = downloadFile.getAbsolutePath();

        return savePath;
    }


    private String getNameFromUrl(String url) {
        return url.substring(url.lastIndexOf("/") + 1);
    }


    /**
     * interface of download process
     */
    public interface OnDownloadListener {
        void onSuc();

        void onProgress(int progress);

        void onErr(String error);
    }


    public static void main(String[] args) {
//        DownLoadT.getInstance().download("http://10.73.150.101:8080/iflytek/app/app/apkPath", "d:/aaa.apk", new OnDownloadListener() {
        DownLoadT.getInstance().download("http://172.31.3.85:9001/apk/1517984706040.apk", "d:/1517984706040.apk", new OnDownloadListener() {
            @Override
            public void onSuc() {

            }

            @Override
            public void onProgress(int progress) {
                System.out.println(progress);
            }

            @Override
            public void onErr(String error) {

            }
        });
    }
}