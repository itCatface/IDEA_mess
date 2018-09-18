package util.net.okhttp;

import util.net.okhttp.imp.OkHttpT;

import java.util.Map;

/**
 * Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public interface IOkHttp {

    void get(final String url, OkHttpT.OKCallback callback);

    void get(final String url, Map<String, String> map, OkHttpT.OKCallback callback);


    void post(final String url, final Map<String, String> map, OkHttpT.OKCallback callback);

    void post(String url, String json, final OkHttpT.OKCallback callback);


    void upload(String url, String filePath, OkHttpT.OKCallback callback);                                 // 所上传文件的默认key为file

    void upload(String url, Map<String, String> map, String filePath, OkHttpT.OKCallback callback);        // 所上传文件的默认key为file

    void upload(String url, Map<String, String> map, Map<String, String> fileMap, OkHttpT.OKCallback callback);        // 所上传文件的默认key为file


    void download(final String url, final String fileDir, final String fileName, OkHttpT.OKCallback callback);


    /* 同步请求 */
    String get(String url);

    String post(String url, Map<String, String> map);

    String post(String url, String json);
}
