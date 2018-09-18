package util.net.retrofit.imp;

import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.Result;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import util.net.okhttp.imp.DownloadEngine;
import util.net.retrofit.RetrofitApi;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class RetrofitT {
    final int TIMEOUT = 30;

    private static RetrofitT mInstance;
    private static OkHttpClient mClient;

    public static RetrofitT getInstance() {
        if (null == mInstance) {
            synchronized (RetrofitT.class) {
                if (null == mInstance) {
                    mInstance = new RetrofitT();
                }
            }
        }

        return mInstance;
    }

    private RetrofitT() {
        mClient = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                //                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE))
                //                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
                //                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
                //                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(new LoggingInterceptor())
                .build();
    }


    private Class<RetrofitApi> clz = RetrofitApi.class;

    private <T> T getApi(String host, Class<T> clz) {
        /* 通过OkHttpClient设置Retrofit的超时时长 */
        return new Retrofit.Builder().baseUrl(host).client(mClient).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(ScalarsConverterFactory.create()).build().create(clz);
    }


    public void get(String host, String suffix, RetrofitCallback callback) {
        RetrofitApi api = getApi(host, clz);
        Call<String> call = api.get(suffix);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                response(response, callback);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                failure(t.toString(), callback);
            }
        });
    }


    public void get(String host, String suffix, Map<String, String> map, RetrofitCallback callback) {
        RetrofitApi api = getApi(host, clz);
        Call<String> call = api.get(suffix, map);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                response(response, callback);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                failure(t.toString(), callback);
            }
        });
    }


    public void post(String host, String suffix, Map<String, String> map, RetrofitCallback callback) {
        RetrofitApi api = getApi(host, clz);
        Call<String> call = api.post(suffix, map);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                response(response, callback);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                failure(t.toString(), callback);
            }
        });
    }


    public void post(String host, String suffix, String json, RetrofitCallback callback) {
        RetrofitApi api = getApi(host, clz);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), json);
        Call<String> call = api.post(suffix, body);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                response(response, callback);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                failure(t.toString(), callback);
            }
        });
    }


    public void postField(String host, String suffix, Map<String, String> map, RetrofitCallback callback) {
        RetrofitApi api = getApi(host, clz);
        Call<String> call = api.postField(suffix, map);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                response(response, callback);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                failure(t.toString(), callback);
            }
        });
    }


    public void upload(String host, String suffix, String filePath, RetrofitCallback callback) {
        RetrofitApi api = getApi(host, clz);
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            failure("当前上传文件不存在: " + filePath, callback);
            return;
        }

        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
        Call<String> call = api.upload(suffix, part);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                response(response, callback);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                failure(t.toString(), callback);
            }
        });
    }


    public void upload(String host, String suffix, Map<String, String> map, String filePath, RetrofitCallback callback) {
        Map<String, String> fileMap = new HashMap<>();
        fileMap.put("file", filePath);
        upload(host, suffix, map, fileMap, callback);
    }


    public void upload(String host, String suffix, Map<String, String> map, Map<String, String> fileMap, RetrofitCallback callback) {
        RetrofitApi api = getApi(host, clz);
        Map<String, RequestBody> bodyMap = new HashMap<>();
        for (String key : fileMap.keySet()) {
            File file = new File(fileMap.get(key));
            if (null == file || !file.exists() || !file.isFile())
                System.out.println("RetrofitT-->upload-->当前文件不可上传: " + file.getAbsolutePath());
            else
                bodyMap.put(key + "\"; filename=\"" + file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file));
        }

        Call<String> call = api.upload(suffix, map != null ? map : new HashMap<>(), bodyMap);   // java.lang.IllegalArgumentException: Query map was null.
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                response(response, callback);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                failure(t.toString(), callback);
            }
        });
    }


    public void upload(String host, String suffix, Map<String, String> map, List<File> files, RetrofitCallback callback) {
        RetrofitApi api = getApi(host, clz);

        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);

        for (String key : map.keySet()) {
            builder.addFormDataPart(key, map.get(key));
        }

        for (File file : files) {
            builder.addFormDataPart("file[]", file.getName(), RequestBody.create(MediaType.parse("image/*"), file));
        }
        RequestBody requestBody = builder.build();


        Call<String> call = api.upload(suffix, requestBody);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                response(response, callback);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                failure(t.toString(), callback);
            }
        });
    }


    public void download(String host, String suffix, RetrofitCallback callback) {
        RetrofitApi api = getApi(host, clz);
        Call<ResponseBody> call = api.download(suffix);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //                System.out.println("++++++++++++"+response.headers().names());
                DownloadEngine.response2ROM(response.body(), "C:\\Users\\Administrator\\Desktop\\temp1.jpg", new DownloadEngine.OnDownloadListener() {
                    @Override
                    public void onSuc() {
                        System.out.println("suc");
                    }

                    @Override
                    public void onProgress(Float progress) {
                        System.out.println(progress);
                    }

                    @Override
                    public void onErr(String error) {

                    }
                });
                response(response, callback);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                failure(t.toString(), callback);
            }
        });
    }


    /***** 带进度的文件上传和下载 *****/
    public void uploadWithProgress(String url, String filePath, util.net.retrofit.imp.progress.RetrofitCallback callback) {
        RetrofitApi api = getApi(url, clz);

        File file = new File(filePath);
        RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        Call<Result> call = api.uploadWithProgress(body);
        if (null != callback)
            call.enqueue(callback);
    }


    public interface RetrofitCallback {
        void onSuc(String result);

        void onErr(String err);
    }


    boolean IN_UI = false;

    private void failure(String msg, RetrofitCallback callback) {
        if (IN_UI) {

        } else callback.onErr(msg);
    }

    private void response(Response response, RetrofitCallback callback) {
        try {
            if (response.isSuccessful()) if (IN_UI) {

            } else callback.onSuc(response.body().toString());
            else {
                if (IN_UI) {

                } else callback.onErr("OkHttpT-->get-->errorCode: " + response.code());
            }
        } catch (Exception e) {

        }
    }


    /* 传入完整url */
    public void get(String url, RetrofitCallback callback) {
        get(url + "/", "", callback);
    }

    public void get(String host, Map<String, String> map, RetrofitCallback callback) {
        get(host + "/", "", map, callback);
    }

    public void post(String url, Map<String, String> map, RetrofitCallback callback) {
        post(url + "/", "", map, callback);
    }

    public void post(String url, String json, RetrofitCallback callback) {
        post(url + "/", "", json, callback);
    }

    public void postField(String url, Map<String, String> map, RetrofitCallback callback) {
        postField(url + "/", "", map, callback);
    }

    public void upload(String url, String filePath, RetrofitCallback callback) {
        upload(url + "/", "", filePath, callback);
    }

    public void upload(String url, Map<String, String> map, String filePath, RetrofitCallback callback) {
        upload(url + "/", "", map, filePath, callback);
    }

    public void upload(String url, Map<String, String> map, Map<String, String> fileMap, RetrofitCallback callback) {
        upload(url + "/", "", map, fileMap, callback);
    }

    public void upload(String host, Map<String, String> map, List<File> files, RetrofitCallback callback) {
        upload(host + "/", "", map, files, callback);
    }

    public void download(String url, RetrofitCallback callback) {
        download(url + "/", "", callback);
    }
}
