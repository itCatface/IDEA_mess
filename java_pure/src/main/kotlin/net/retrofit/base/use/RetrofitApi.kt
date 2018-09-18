package net.retrofit.base.use

import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.POST
import retrofit2.http.Multipart
import retrofit2.http.PartMap

/**
 * Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
interface RetrofitApi {

    /* 1. 仅请求服务器数据 */
    @GET(".")
    fun register(): Call<String>


    /* 2. 上传参数 */
    @GET("hi/register")
    fun register(@QueryMap map: Map<String, String>): Call<String>


    /* 3. ???上传json[暂时处于僵硬状态...] */
    @POST("postJson")
    fun postJson(@Body user: User): Call<String>


    /* 4. 上传单个文件 */
    @Multipart
    @POST(".")
    fun uploadFile(@Part("description") description: RequestBody, @Part file: MultipartBody.Part): Call<String>


    /* 5. 上传多个文件 & 多个参数 */
    @JvmSuppressWildcards   // [IllegalArgumentException: Parameter type must not include a type variable or wildcard]
    @Multipart
    @POST(".")
    fun uploadFiles(@PartMap fileMap: Map<String, RequestBody>, @QueryMap map: Map<String, String>): Call<String>


    /* 6. 下载文件 */
    @Streaming  // 避免下载大文件被Retrofit整个读进内存
    @GET("downloadFile")
    fun download(): Call<ResponseBody>
}