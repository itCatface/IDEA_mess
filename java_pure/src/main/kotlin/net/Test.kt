package net

import net.http.HttpT
import net.http.MultiThreadHttpDownloadT
import net.retrofit.base.encapsulation.DownloadEngine
import net.retrofit.base.encapsulation.RetrofitT
import extention.log
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Test {

    @JvmStatic
    fun main(args: Array<String>) {
//        post(mapOf("username" to "catface", "password" to "请问qwer"))
//        retrofit()
//        http()
//        xfhTest()


        val s = "{\"isSecret\":true,\"retinfo\":\"成功！\",\"list\":[{\"infoNo\":\"101219432535\",\"createTime\":\"20170811092541\",\"dealTypeName\":\"套卡激活\",\"custOrderId\":\"71002333840882\",\"dealType\":\"500000020009\",\"orgId\":\"10030520\",\"infoSino\":\"\"},\"\"],\"retcode\":\"0\"}"

//        try {
//            val data = JSON.parseObject(s, PaperlessListing::class.java)
//        }catch (e:Exception) {
//            println(e)
//        }
//        println(data.retcode)


//        openAccount()
    }

    /*************************************** 接口测试 ***************************************/
    val HOST = "http://10.73.150.83:8282/zjydService/"

    private fun openAccount() {
        var map = mapOf("opId" to "20130795", "opOrgId" to "10030520", "operType" to "1",
                "useType" to "1",
                "pageNum" to "1",
                "pageCount" to "100")
        val post = HttpT.post("${HOST}zjyd/esb/repertory/", map)
        log(post)

        map = emptyMap()
        map = mapOf("cardInfo" to "1"
        )
    }


    /*************************************** 其他测试 ***************************************/
    private fun xfhTest() {
        RetrofitT.get("v1.0/News/Redian.api", object : Callback<String> {
            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                println(response?.body())
            }

            override fun onFailure(call: Call<String>?, t: Throwable?) {

            }

        }, host = "http://xkapi.com/")
    }


    /************************************** Retrofit测试 **********************************/
    private fun retrofit() {
        get()

        post(mapOf("username" to "catface", "password" to "请问qwer"))

        upload("D:/下载/图片/ic_launcher.png")

        val map = mapOf("usernam23e" to "catfa234ce", "passwo234rd" to "请问q524wer")
        val fileMap = mapOf("fileA" to "D:/下载/图片/ic_launcher.png", "fileB" to "D:/下载/图片/girl01.jpg")
        upload(map, fileMap)

        download()
    }


    private fun get() {
        RetrofitT.get("hi/register", object : Callback<String> {
            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                println(response?.body())
            }

            override fun onFailure(call: Call<String>?, t: Throwable?) {
                println(t.toString())
            }
        })
    }


    private fun post(map: Map<String, String>) {
        RetrofitT.post("hi/login", map, object : Callback<String> {
            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                println(response?.body())
            }

            override fun onFailure(call: Call<String>?, t: Throwable?) {
                println(t.toString())
            }
        })
    }


    private fun upload(filePath: String) {
        RetrofitT.upload("hi/uploadFileByJava", filePath, object : Callback<String> {
            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                println(response?.body())
            }

            override fun onFailure(call: Call<String>?, t: Throwable?) {
                println(t.toString())
            }
        })
    }


    private fun upload(map: Map<String, String>, fileMap: Map<String, String>) {
        RetrofitT.upload("hi/uploadFileBySpringAndFileName", map, fileMap, object : Callback<String> {
            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                println(response?.body())
            }

            override fun onFailure(call: Call<String>?, t: Throwable?) {
                println(t.toString())
            }
        })
    }


    private fun download() {
        RetrofitT.download("hi/downloadFile", object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                DownloadEngine.writeResponseBodyToDisk(response?.body()!!, "d:/a_test_dir/Future Studio Icon.jpg", object : DownloadEngine.OnDownloadListener {
                    override fun onSuc() {
                        println("下载成功")
                    }

                    override fun onProgress(progress: Float) {
                        println("下载进度: $progress")
                    }

                    override fun onErr(error: String) {
                        println("下载失败: $error")
                    }

                })
            }

            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                println(t.toString())
            }
        })
    }


    /******************************************* 原生测试 ***************************************/
    private fun http() {
        val s = HttpT.get("http://127.0.0.1:8080/hi/register", null)
        println(s)

        val map = HashMap<String, String>()
        map.put("username", "ads安德森")
        map.put("password", "dfgfd23")
        val s1 = HttpT.post("http://127.0.0.1:8080/hi/login", map)
        println(s1)

        val fileMap = HashMap<String, String>()
        fileMap.put("file", "D:/下载/图片/ic_launcher.png")
        HttpT.upload("http://127.0.0.1:8080/hi/uploadFileByJava", null, fileMap, null)

        fileMap.put("filep", "D:/下载/图片/girl01.jpg")
        HttpT.upload("http://127.0.0.1:8080/hi/uploadFileBySpringAndFileName", map, fileMap, null)


        MultiThreadHttpDownloadT("http://dldir1.qq.com/qqyy/pc/QQPlayer_Setup_39_936.exe", "d:/", 3).download(object : MultiThreadHttpDownloadT.OnDownloadListener {
            override fun onErr(error: String) {

            }

            override fun onSuc(threadId: Int) {

            }

            override fun onProgress(threadId: Int, progress: Int) {
            }
        })
    }
}