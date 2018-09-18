package net.retrofit.base.encapsulation

import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.File
import java.util.*

object RetrofitT {

    fun get(suffixUrl: String, callback: Callback<String>, host: String = RetrofitApi.HOST) {
        val api = getApi(host, clz)

        val call = api.get(suffixUrl)

        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                callback.onResponse(call!!, response!!)
            }

            override fun onFailure(call: Call<String>?, t: Throwable?) {
                callback.onFailure(call!!, t!!)
            }
        })
    }


    fun post(suffixUrl: String, map: Map<String, String>, callback: Callback<String>, host: String = RetrofitApi.HOST) {
        val api = getApi(host, clz)

        val call = api.post(suffixUrl, map)

        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                callback.onResponse(call!!, response!!)
            }

            override fun onFailure(call: Call<String>?, t: Throwable?) {
                callback.onFailure(call!!, t!!)
            }
        })
    }


    fun upload(suffixUrl: String, filePath: String, callback: Callback<String>, host: String = RetrofitApi.HOST) {
        val api = getApi(host, clz)

        val file = File(filePath)
        val requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file)
        val fileBody = MultipartBody.Part.createFormData("file", file.name, requestBody)

        val call = api.upload(suffixUrl, fileBody)

        call.enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>?, t: Throwable?) {
                callback.onFailure(call!!, t!!)
            }

            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                callback.onResponse(call!!, response!!)
            }
        })
    }


    fun upload(suffixUrl: String, map: Map<String, String>, fileMap: Map<String, String>, callback: Callback<String>, host: String = RetrofitApi.HOST) {
        val api = getApi(host, clz)

        val bodyMap = HashMap<String, RequestBody>()
        for ((k, v) in fileMap) {
            val file = File(v)
            bodyMap.put("$k\"; filename=\"${file.name}", RequestBody.create(MediaType.parse("multipart/form-data"), file))
        }

        val call = api.upload(suffixUrl, map, bodyMap)

        call.enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>?, t: Throwable?) {
                callback.onFailure(call!!, t!!)
            }

            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                callback.onResponse(call!!, response!!)
            }
        })
    }


    fun download(suffixUrl: String, callback: Callback<ResponseBody>, host: String = RetrofitApi.HOST) {
        val api = getApi(host, clz)

        val call = api.download(suffixUrl)

        call.enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                callback.onFailure(call!!, t!!)
            }

            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                if (response!!.isSuccessful)
                    callback.onResponse(call!!, response)
            }
        })
    }


    /* 私有方法 */
    private val clz = RetrofitApi::class.java

    private fun <T> getApi(host: String, clazz: Class<T>): T {
        val retrofit = Retrofit.Builder()
                .baseUrl(host)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()

        return retrofit.create(clazz) as T
    }
}