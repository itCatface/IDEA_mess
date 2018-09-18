package util.net.http.imp;

import util.lang.StringT;
import util.net.LogT;
import util.net.http.IHttp;

import javax.activation.MimetypesFileTypeMap;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class HttpT implements IHttp {

    private static HttpT mInstance;

    public static HttpT getInstance() {
        if (null == mInstance) {
            synchronized (HttpT.class) {
                if (null == mInstance) {
                    mInstance = new HttpT();
                }
            }
        }

        return mInstance;
    }

    private String t;
    public  void setT(String a ){
        t = a;
    }
    public String getT() {
        return t;
    }


    @Override
    public String get(String url) {
        return get(url, null);
    }

    @Override
    public String get(String url, Map<String, String> map) {
        LogT.net(url, map);

        String result = "";
        BufferedReader reader = null;

        try {
            String urlSuffix = "";
            if (null != map) {
                for (String key : map.keySet()) {
                    urlSuffix += key + "=" + map.get(key) + "&";
                }
                url += "?" + urlSuffix.substring(0, urlSuffix.length() - 1);
            }

            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result += line;
            }

        } catch (Exception e) {
            result = "HttpT-->get-->exception: " + e.toString();

        } finally {
            try {
                if (null != reader) reader.close();
            } catch (Exception e) {
                result = "HttpT-->get-->exception: " + e.toString();
            }
        }

        LogT.d(result);
        return result;
    }


    @Override
    public String post(String url, Map<String, String> map) {
        LogT.net(url, map);

        PrintWriter out = null;
        BufferedReader reader = null;
        String result = "";

        try {
            URLConnection conn = new URL(url).openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8"); // 文件类型

            conn.setDoOutput(true); // must set if use post
            conn.setDoInput(true);  // must set if use post
            out = new PrintWriter(conn.getOutputStream());

            String totalUrl = "";
            String urlSuffix = "";
            if (null != map) {
                for (String key : map.keySet()) {
                    urlSuffix += (key + "=" + map.get(key) + "&");
                }

                totalUrl = urlSuffix.substring(0, urlSuffix.length() - 1);
            }

            out.print(totalUrl);

            out.flush();
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result += line;
            }

        } catch (Exception e) {
            result = "HttpT-->post-->exception: " + e.toString();

        } finally {
            try {
                if (out != null) out.close();
                if (reader != null) reader.close();

            } catch (IOException e) {
                result = "HttpT-->post-->exception: " + e.toString();
            }
        }

        LogT.d(result);
        return result;
    }


    @Override
    public String post(String url, String json) {
        LogT.d("HttpT-->post", url + " : " + json);

        String result;
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Charset", "UTF-8");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8"); // 文件类型
            // 防止415
            conn.setRequestProperty("accept", "application/json");
            if (json != null && !"".equals(json)) {
                byte[] bytes = json.getBytes();
                conn.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                OutputStream os = conn.getOutputStream();
                os.write(json.getBytes());
                os.flush();
                os.close();
            }

            if (conn.getResponseCode() == 200) {
                InputStream inputStream = conn.getInputStream();
                result = StringT.stream2Str(inputStream);
            } else {
                result = "服务器返回code非200: " + conn.getResponseCode();
            }

        } catch (Exception e) {
            result = "HttpT-->post-->exception: " + e.toString();
        }

        LogT.d("HttpT-->post", result);
        return result;
    }


    @Override
    public String upload(String url, String filePath) {
        Map<String, String> fileMap = new HashMap<>();
        fileMap.put("file", filePath);
        return upload(url, null, fileMap, null);
    }


    @Override
    public String upload(String url, Map<String, String> map, String filePath) {
        Map<String, String> fileMap = new HashMap<>();
        fileMap.put("file", filePath);
        return upload(url, map, fileMap, null);
    }


    @Override
    public String upload(String url, Map<String, String> map, Map<String, String> fileMap) {
        return upload(url, map, fileMap, null);
    }


    @Override
    public String upload(String url, Map<String, String> map, Map<String, String> fileMap, Map<String, String> headers) {
        String result;

        OutputStream os = null;
        DataInputStream dis = null;

        HttpURLConnection conn = null;
        String BOUNDARY = "---------------------------123821742118716"; // 请求头参数和上传文件的分隔符
        try {
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");

            if (null != headers) {  // 1. headers(cookie)
                for (String key : headers.keySet()) {
                    conn.addRequestProperty(key, headers.get(key));
                }
            }

            conn.setRequestProperty("Connection", "Keep-Alive");
            // conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

            os = new DataOutputStream(conn.getOutputStream());

            if (null != map) {   // 2. params
                StringBuffer sb = new StringBuffer();
                for (String key : map.keySet()) {
                    if (null == key) continue;
                    sb.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
                    sb.append("Content-Disposition: form-data; name=\"" + key + "\"\r\n\r\n");
                    sb.append(map.get(key));
                }
                os.write(sb.toString().getBytes());
            }

            if (null != fileMap) {  // 3. files
                for (String key : fileMap.keySet()) {
                    if (null == key) continue;

                    File file = new File(fileMap.get(key));
                    if (!file.exists()) {
                        System.out.println("HttpT-->upload-->the file from path: " + fileMap.get(key) + ":: dose not exists!");
                        continue;
                    }

                    String filename = file.getName();
                    String contentType = new MimetypesFileTypeMap().getContentType(file);
                    if (filename.endsWith(".png")) {
                        contentType = "image/png";
                    }
                    if (null == contentType || "".equals(contentType)) {
                        contentType = "application/octet-stream";
                    }

                    StringBuffer sb = new StringBuffer();
                    sb.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
                    sb.append("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"" + filename + "\"\r\n");
                    sb.append("Content-Type:" + contentType + "\r\n\r\n");

                    os.write(sb.toString().getBytes());

                    dis = new DataInputStream(new FileInputStream(file));
                    int bytes;
                    byte[] bufferOut = new byte[1024];
                    while ((bytes = dis.read(bufferOut)) != -1) {
                        os.write(bufferOut, 0, bytes);
                    }
                    dis.close();
                }
            }

            byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
            os.write(endData);
            os.flush();
            os.close();


            StringBuffer buffer = new StringBuffer();   // 4. 获取服务器返回的信息
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line).append("\n");
            }
            reader.close();
            result = buffer.toString();

        } catch (Exception e) {
            result = "HttpT-->upload-->exception: " + e.toString();

        } finally {
            try {
                if (null != dis) dis.close();
                if (null != os) os.close();
                if (null != conn) conn.disconnect();
            } catch (IOException e) {
                result = "HttpT-->upload-->exception: " + e.toString();
            }
        }

        return result;
    }


    @Override
    public String download(String url, String dir, String fileName) {
        String result;

        BufferedOutputStream bos = null;
        InputStream is = null;

        try {
            byte[] buff = new byte[8192];

            // is = new URL(url).openStream();
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            is = conn.getInputStream();

            File file = new File(dir, fileName);
            file.getParentFile().mkdirs();
            bos = new BufferedOutputStream(new FileOutputStream(file));
            int count;
            while ((count = is.read(buff)) != -1) {
                bos.write(buff, 0, count);
            }
            result = "HttpT-->download-->success!";

        } catch (IOException e) {
            result = "HttpT-->download-->exception: " + e.toString();

        } finally {
            try {
                if (bos != null) bos.close();
                if (is != null) is.close();
            } catch (IOException e) {
                result = "HttpT-->download-->exception: " + e.toString();
            }
        }

        return result;
    }
}