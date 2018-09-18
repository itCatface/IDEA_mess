package util.net.http;

import java.util.Map;

/**
 * Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public interface IHttp {

    String get(String url);

    String get(String url, Map<String, String> params);


    String post(String url, Map<String, String> params);

    String post(String url, String json);


    String upload(String url, String filePath);                                 // 所上传文件的默认key为file

    String upload(String url, Map<String, String> map, String filePath);        // 所上传文件的默认key为file

    String upload(String url, Map<String, String> params, Map<String, String> fileMap);

    String upload(String url, Map<String, String> map, Map<String, String> fileMap, Map<String, String> headers);


    String download(String url, String saveDir, String fileName);
}
