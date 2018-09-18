package net.retrofit.base.encapsulation

import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
interface RetrofitApi {

    companion object {
        val HOST = "http://127.0.0.1:8080/"
    }


    /* 1. 仅请求服务器数据 */
    @GET
    fun get(@Url suffixUrl: String): Call<String>


    /* 2. 上传参数 */
    @POST
    fun post(@Url suffixUrl: String, @QueryMap map: Map<String, String>): Call<String>


    /* 3. ???上传json[暂时处于僵硬状态...] */
    /*@POST("postJson")
    function postJson(@Body user: User): Call<String>*/


    /* 4. 上传单个文件 */
    @Multipart
    @POST
    fun upload(@Url suffixUrl: String, @Part file: MultipartBody.Part): Call<String>


    /* 5. 上传多个文件 & 多个参数 */
    @JvmSuppressWildcards   // [IllegalArgumentException: Parameter type must not include a type variable or wildcard]
    @Multipart
    @POST
    fun upload(@Url suffixUrl: String, @QueryMap map: Map<String, String>, @PartMap fileMap: Map<String, RequestBody>): Call<String>


    /* 6. 下载文件 */
    @Streaming  // 避免下载大文件被Retrofit整个读进内存
    @GET
    fun download(@Url suffixUrl: String): Call<ResponseBody>
}