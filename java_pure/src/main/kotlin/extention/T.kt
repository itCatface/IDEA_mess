package extention

import net.retrofit.base.encapsulation.RetrofitT
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
object T {


    @JvmStatic
    fun main(args: Array<String>) {

//        fileDelete(File("D:\\a\\新建文件夹"))

//        fileCopy(File("D:\\张国荣,黄耀明 - 这么远 那么近.mp3"), File("D:\\test.mp3"), true)
//        fileCopy(File("D:\\a"), File("D:\\aaa"), true)

//        zip(File("D:\\a"), File("D:\\z.zip"), overwrite = true)

//        writeStr2File(File("D:\\a\\q\\q2.txt"), "dfa爱的")

//        getAll(File("D:\\a\\p.properties"))?.iterator()?.forEach {
//            println("${it.key}--${it.value}")
//        }
//        println(getValues(File("D:\\a\\p.properties"), "q1"))
//        println(getValues(File("D:\\a\\p.properties"), "q2请问"))
//        setValues(File("D:\\a\\p.properties"), "q4", "qwewq其味无穷2")


//        d("斯蒂芬森分sadf爱的方式(^^*(()(（）（）&*&（f 防盗）")
//        d("斯蒂芬森分sadf爱的方式(^^*(()(（）（）&*&（f 防盗）", "qw请问")
//
//        net("http:asfdasf松岛枫", mapOf())
//        net("http:asfdasf松岛枫", mapOf("asf" to "saf松岛枫", "a松岛枫" to "qwwrw额"))
//        net("http:asfdasf松岛枫", mapOf("asf" to "saf松岛枫", "a松岛枫" to "qwwrw额"), "df防盗")


//        var arrFiles = arrayOfNulls<String>(1024)
//        val mListFiles = arrayListOf<String>()
//        mListFiles.add("123")
//        mListFiles.add("223")
//        mListFiles.add("323")
//        for (i in mListFiles.indices) {
//            arrFiles[i] = mListFiles[i]
//        }
//        println("" + arrFiles.size + "||" + arrFiles[1])


//        val flagFile = File("d:/flag.txt")
//        if (flagFile.exists() && flagFile.isFile && "Y" == flagFile.readText().trim()) {
//            println(flagFile.readText().trim())
//        } else {
//            println("donst exists or not Y")
//        }



//        var result = 0L
////        val fileName = "crash_readable_1516781297728.txt"
//        val fileName = "crash_readable_64469203.txt"
//
////        val fileName = "Log_20180206153957.txt"
////        val fileName = "20180206111508_image_ref1.jpg"
////        val fileName = "ffe73fd7a278d0839122f68a9cf9f8c4_20180206154213_image_ref1.jpg"
//        if (fileName.startsWith("crash_readable_")) {
//            val dtStr = fileName.substring(16, fileName.indexOf(".txt"))
//            result = timeStamp2DateStr(dtStr.toLong(), 0).toLong()
//
//        } else if(fileName.startsWith("Log_")){
//            val start = fileName.indexOf("2")
//            result = fileName.substring(start, start + 14).toLong()
//        } else if(fileName.contains("201")) {
//            val start = fileName.indexOf("201")
//            result = fileName.substring(start, start + 14).toLong()
//        }
//
//        println(result)


//        for (i in 1..9) {
//            for (j in 1..9) {
//                println(j)
//            }
//
//            println(i)
//        }


        RetrofitT.upload("d-web/save/d/uploadLog", "d:/a.mp4", object : Callback<String>{
            override fun onFailure(call: Call<String>?, t: Throwable?) {
                println(t.toString())
            }

            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                println(response?.body())
            }

        },host = "http://10.5.130.89:8080/")



        println("finish...")
    }
}