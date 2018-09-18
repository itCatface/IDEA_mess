package util.net.okhttp.imp;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.*;
import sun.rmi.runtime.Log;
import util.net.okhttp.IOkHttp;
import util.net.retrofit.imp.RetrofitT;

/**
 * @version 1.0.0
 * @attention // OKHttp in gradle
 * compile 'com.squareup.okhttp3:okhttp:3.5.0'
 * compile 'com.squareup.okio:okio:1.11.0'
 */

public class OkHttpT implements IOkHttp {

    private final boolean IN_UI = false;

    private static OkHttpT mInstance;
    private static OkHttpClient mOkHttpClient;

    /**
     * use/not use single instance to get OkHttpClient
     */
    public static OkHttpT getInstance() {
        if (null == mInstance) {
            synchronized (OkHttpT.class) {
                if (null == mInstance) mInstance = new OkHttpT();
            }
        }
        return mInstance;
    }

    private OkHttpT() {
        mOkHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).writeTimeout(15, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS).build();
    }


    public interface OKCallback {
        void onSuc(String result);

        void onErr(String err);
    }


    @Override
    public void get(final String url, final OKCallback callback) {
        get(url, null, callback);
    }


    @Override
    public void get(final String url, Map<String, String> map, final OKCallback callback) {
        StringBuilder builder = new StringBuilder().append(url);

        if (null != map) {
            builder.append("?");
            int position = 0;
            for (String key : map.keySet()) {
                if (position > 0) {
                    builder.append("&");
                }
                builder.append(String.format("%s=%s", key, map.get(key)));
                position++;
            }
        }

        mOkHttpClient.newCall(new Request.Builder().url(builder.toString()).build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                failure(e.toString(), callback);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                response(response, callback);
            }
        });
    }


    @Override
    public void post(final String url, final Map<String, String> map, final OKCallback callback) {
        FormBody.Builder builder = new FormBody.Builder();

        if (null != map)
            for (String key : map.keySet()) {
                builder.add(key, map.get(key));
            }

        mOkHttpClient.newCall(new Request.Builder().url(url).post(builder.build()).build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                failure(e.toString(), callback);
            }

            @Override
            public void onResponse(Call call, Response response) {
                response(response, callback);
            }
        });
    }


    @Override
    public void post(String url, String json, final OKCallback callback) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder().url(url).post(requestBody).build();

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                failure(e.toString(), callback);
            }

            @Override
            public void onResponse(Call call, Response response) {
                response(response, callback);
            }
        });
    }


    @Override
    public void upload(String url, String filePath, OKCallback callback) {
        Map<String, String> fileMap = new HashMap<>();
        fileMap.put("file", filePath);
        upload(url, null, fileMap, callback);
    }


    @Override
    public void upload(String url, Map<String, String> map, String filePath, OKCallback callback) {
        Map<String, String> fileMap = new HashMap<>();
        fileMap.put("file", filePath);
        upload(url, map, fileMap, callback);
    }


    @Override
    public void upload(final String url, final Map<String, String> params, final Map<String, String> fileMap, final OKCallback callback) {
        /* A. 拦截无上传文件的操作 */
        boolean flag = false;
        for (String filePath : fileMap.keySet()) {
            if (new File(fileMap.get(filePath)).exists()) {
                flag = true;
            }
        }
        if (!flag) {
            failure("OkHttpT-->upload-->无任何可上传文件", callback);
            return;
        }


        /* B. 构建文件上传器 */
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);

        if (null != params)     // 1. params
            for (String key : params.keySet()) {
                builder.addFormDataPart(key, params.get(key));
            }

        if (null != fileMap)    // 2. files
            for (String key : fileMap.keySet()) {
                File file = new File(fileMap.get(key));
                if (null == file || !file.exists()) {
                    System.out.println("OkHttpT-->upload-->the file from path:: " + fileMap.get(key) + " :: dose not exists!");
                } else {
                    builder.addFormDataPart(key, file.getName(), RequestBody.create(MediaType.parse("application/octet-stream"), file));
                }
            }

        mOkHttpClient.newCall(new Request.Builder().url(url).post(builder.build()).build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                failure(e.toString(), callback);
            }

            @Override
            public void onResponse(Call call, Response response) {
                response(response, callback);
            }
        });
    }


    public void download(final String url, final String fileDir, final String fileName, final OKCallback callback) {
        mOkHttpClient.newCall(new Request.Builder().url(url).build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                failure(e.toString(), callback);
            }

            @Override
            public void onResponse(Call call, Response response) {
                FileOutputStream fos = null;
                InputStream is = null;

                try {
                    File file = new File(fileDir);
                    if (!file.exists()) {
                        boolean result = file.mkdir();
                        if (!result) {
                            failure("文件目录创建失败", callback);
                            return;
                        }
                    }
                    file = new File(fileDir, fileName);
                    if (!file.exists()) {
                        boolean result = file.createNewFile();
                        if (!result) {
                            failure("文件创建失败", callback);
                            return;
                        }
                    }
                    fos = new FileOutputStream(file);
                    ResponseBody body = response.body();
                    if (null == body) {
                        failure("OkHttpT-->download-->response.body() == null!", callback);
                        return;
                    }

                    is = body.byteStream();
                    byte[] buffer = new byte[2048];
                    int len;
                    while (-1 != (len = is.read(buffer))) {
                        fos.write(buffer, 0, len);
                    }

                    System.out.println("OkHttpT-->download-->success: " + "下载地址===" + url + " || 本地存储地址===" + file.getAbsolutePath());
                    response(response, callback);

                } catch (IOException e) {
                    failure(e.toString(), callback);

                } finally {
                    try {
                        if (null != fos) fos.close();
                        if (null != is) is.close();
                    } catch (IOException e) {
                        failure(e.toString(), callback);
                    }
                }
            }
        });
    }


    private void failure(String msg, OKCallback callback) {
        if (IN_UI) {

        } else callback.onErr(msg);
    }

    private void response(Response response, OKCallback callback) {
        try {
            if (response.isSuccessful()) {
                ResponseBody body = response.body();
                if (null == body) {
                    callback.onErr("OkHttpT-->response-->failure: response.body() == null");
                    return;
                }

                if (IN_UI) {

                } else callback.onSuc(body.string());
            } else {
                if (IN_UI) {

                } else callback.onErr("OkHttpT-->get-->errorCode: " + response.code());
            }
        } catch (Exception e) {

        }
    }


    @Override
    public String get(String url) {
        try {
            Request request = new Request.Builder().url(url).build();
            Response response = mOkHttpClient.newCall(request).execute();
            ResponseBody body = response.body();

            if (null == body) return "OkHttpT-->get(sync)-->failure-->response == null";
            if (!response.isSuccessful()) return "OkHttpT-->get(sync)-->failure-->errorCode: " + response.code();

            Headers responseHeaders = response.headers();
            for (int i = 0; i < responseHeaders.size(); i++) {
                System.out.println("OkHttpT-->get(sync)-->success-->headers: " + responseHeaders.name(i) + ": " + responseHeaders.value(i));
            }
            return body.string();

        } catch (Exception e) {
            return "OkHttpT-->get(sync)-->exception: " + e.toString();
        }
    }


    @Override
    public String post(String url, Map<String, String> map) {
        try {
            FormBody.Builder builder = new FormBody.Builder();

            if (null != map)
                for (String key : map.keySet()) {
                    builder.add(key, map.get(key));
                }

            RequestBody requestBody = builder.build();
            Request request = new Request.Builder().url(url).post(requestBody).build();
            Response response = mOkHttpClient.newCall(request).execute();
            ResponseBody body = response.body();
            if (null == body) return "OkHttpT-->post(sync)-->failure-->response == null";
            if (!response.isSuccessful()) return "OkHttpT-->post(sync)-->failure-->errorCode: " + response.code();
            return body.string();

        } catch (Exception e) {
            return "OkHttpT-->post(sync)-->exception: " + e.toString();
        }
    }


    @Override
    public String post(String url, String json) {
        try {
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
            Request request = new Request.Builder().url(url).post(requestBody).build();
            Response response = mOkHttpClient.newCall(request).execute();
            ResponseBody body = response.body();
            if (null == body) return "OkHttpT-->post(sync)-->failure-->response == null";
            if (!response.isSuccessful()) return "OkHttpT-->post(sync)-->failure-->errorCode: " + response.code();
            return body.string();

        } catch (Exception e) {
            return "OkHttpT-->post(sync)-->exception: " + e.toString();
        }
    }
}
