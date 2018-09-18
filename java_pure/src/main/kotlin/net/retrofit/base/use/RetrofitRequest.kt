package net.retrofit.base.use


import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.*
import java.util.HashMap

object RetrofitRequest {

    @JvmStatic
    fun main(args: Array<String>) {
//        register()
//        registerWithParams()
//        postJson()
//        uploadFile()
//        uploadFiles()
        download()
    }


    private fun register() {
        // 先来个模子 -> 给模子加花 -> 通过模子刻个实例出来
        val retrofit = Retrofit.Builder()   // 创建客户端建造器
                .baseUrl("http://127.0.0.1:8080/hi/register/")   // 添加主机地址
                .addConverterFactory(ScalarsConverterFactory.create()) // 制定数据解析器[可用gson、jackson等或自定制]
                .build()    // 创建客户端实例

        val api = retrofit.create(RetrofitApi::class.java)  // 获取Api实例

        val call = api.register()   // 通过Api实例获取一个Call对象

        call.enqueue(object : Callback<String> {  // 开始请求[enqueue(异步) | execute(同步)]
            override fun onFailure(call: Call<String>?, t: Throwable?) {
                println("请求失败: ${t.toString()}")
            }

            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                println("请求成功: ${response?.body()}")
            }
        })
    }


    private fun registerWithParams() {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8080/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()

        val api = retrofit.create(RetrofitApi::class.java)

        val call = api.register(mapOf("username" to "catface", "password" to "root"))   // 添加请求参数map

        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                println("请求成功: ${response?.body()}")
            }

            override fun onFailure(call: Call<String>?, t: Throwable?) {
                println("请求失败: ${t.toString()}")
            }

        })
    }


    // 僵硬中...
    private fun postJson() {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val api = retrofit.create(RetrofitApi::class.java)

        val call = api.postJson(User("root", "catface"))

        call.enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>?, t: Throwable?) {
                println("请求失败: ${t.toString()}")
            }

            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                println("请求成功: ${response?.body()}")
            }
        })
    }


    private fun uploadFile() {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl("http://127.0.0.1:8080/hi/uploadFileByJava/")
                .build()

        val api = retrofit.create(RetrofitApi::class.java)

        val file = File("D:/下载/图片/ic_launcher.png")
        val requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file)
        val fileBody = MultipartBody.Part.createFormData("file", file.name, requestBody)

        val description = RequestBody.create(MediaType.parse("multipart/form-data"), "This is a description")

        val call = api.uploadFile(description, fileBody)

        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                println("请求成功: ${response.body().toString()}")
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                println("请求失败: ${t.toString()}")
            }
        })
    }


    private fun uploadFiles() {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8080/hi/uploadFileBySpringAndFileName/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()

        val api = retrofit.create(RetrofitApi::class.java)

        /* 文件 */
        val fileMap = HashMap<String, RequestBody>()
        val file1 = File("D:/下载/图片/ic_launcher.png")
        val file2 = File("D:/下载/图片/girl01.jpg")
        fileMap.put("file1\"; filename=\"" + file1.name, RequestBody.create(MediaType.parse("multipart/form-data"), file1))
        fileMap.put("file2\"; filename=\"" + file2.name, RequestBody.create(MediaType.parse("multipart/form-data"), file2))

        /* 参数 */
        val map = HashMap<String, String>()
        map.put("username", "catface")
        map.put("password", "root")

        val call = api.uploadFiles(fileMap, map)

        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                println("请求成功: ${response?.body()}")
            }

            override fun onFailure(call: Call<String>?, t: Throwable?) {
                println("请求失败: ${t.toString()}")
            }

        })
    }


    private fun download() {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8080/hi/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()

        val api = retrofit.create(RetrofitApi::class.java)

        val call = api.download()

        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                println("请求成功")
                if (response!!.isSuccessful) {
                    writeResponseBodyToDisk(response.body()!!, "d:/a_test_dir/Future Studio Icon.jpg")
                }
            }

            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                println("请求失败: ${t.toString()}")
            }
        })
    }


    /* 将流写到本地的工具 */
    fun writeResponseBodyToDisk(body: ResponseBody, filePath: String): Boolean {
        try {
            val futureStudioIconFile = File(filePath)

            var inputStream: InputStream? = null
            var outputStream: OutputStream? = null

            try {
                val fileReader = ByteArray(4096)

                val fileSize = body.contentLength()
                var fileSizeDownloaded: Long = 0

                inputStream = body.byteStream()
                outputStream = FileOutputStream(futureStudioIconFile)

                while (true) {
                    val read = inputStream!!.read(fileReader)

                    if (read == -1) {
                        break
                    }

                    outputStream.write(fileReader, 0, read)

                    fileSizeDownloaded += read.toLong()

                    println("file download: $fileSizeDownloaded of $fileSize")
                }

                outputStream.flush()

                return true
            } catch (e: IOException) {
                return false
            } finally {
                if (inputStream != null) {
                    inputStream.close()
                }

                if (outputStream != null) {
                    outputStream.close()
                }
            }
        } catch (e: IOException) {
            return false
        }
    }
}