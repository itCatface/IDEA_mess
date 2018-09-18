package net.http

import java.io.File
import java.io.RandomAccessFile
import java.net.HttpURLConnection
import java.net.URL

/**
 * create by wyh
 *
 * @desc download by using multi thread
 */
class MultiThreadHttpDownloadT(val url: String, val savePath: String = "/", val threadCount: Int = 3) {

    /**
     * 下载文件
     */
    @Throws(Exception::class)
    fun download(listener: OnDownloadListener) {

        val conn = URL(url).openConnection() as HttpURLConnection
        conn.requestMethod = "GET"
        conn.connectTimeout = 10000
        conn.readTimeout = 10000

        if (200 == conn.responseCode) {
            // 下载文件总长度
            val totalLength = conn.contentLength
            println(totalLength)

            // 本地创建占位文件(大小与要下载的文件大小一致)
            val randomAccessFile = RandomAccessFile(File(savePath, getFileName(url)), "rw")
            randomAccessFile.setLength(totalLength.toLong())

            // 分割文件长度
            val eachLenth = totalLength / threadCount

            // 分配每个线程需要下载的长度
            for (threadId in 0 until threadCount) {
                // 各线程起始下载位置
                val startIndex = threadId * eachLenth
                // 各线程结束下载位置
                var endIndex = (threadId + 1) * eachLenth - 1
                // 最后一个线程将下载所有剩余长度
                if (threadId == threadCount - 1) {
                    endIndex = totalLength - 1
                }

                // 开启子线程进行下载
                DownloadThread(threadId, startIndex, endIndex, listener).start()
                println("线程_" + threadId + "的下载起点是 " + startIndex + "  下载终点是: " + endIndex)
            }
        }

    }

    private inner class DownloadThread(private val threadId: Int, private var startIndex: Int, private val endIndex: Int, private val listener: OnDownloadListener) : Thread() {

        override fun run() {
            println("线程" + threadId + "开始下载")
            try {
                //分段请求网络连接,分段将文件保存到本地.

                //加载下载位置的文件
                val eachThreadFile = File(savePath, "download_temp_$threadId.dt")
                var eachThreadStream: RandomAccessFile? = null
                if (eachThreadFile.exists()) {//如果文件存在
                    eachThreadStream = RandomAccessFile(eachThreadFile, "rwd")
                    val startIndex_str = eachThreadStream.readLine()
                    if (null == startIndex_str || "" == startIndex_str) {
                        this.startIndex = startIndex
                    } else {
                        this.startIndex = Integer.parseInt(startIndex_str) - 1//设置下载起点
                    }
                } else {
                    eachThreadStream = RandomAccessFile(eachThreadFile, "rwd")
                }


                val conn = URL(url).openConnection() as HttpURLConnection
                conn.requestMethod = "GET"
                conn.connectTimeout = 1000000
                conn.readTimeout = 8000

                // 设置分段下载的头信息
                // Range：分段数据请求时会用到[格式: Range bytes=0-1024  or bytes:0-1024]
                conn.setRequestProperty("Range", "bytes=$startIndex-$endIndex")

                // 206：部分资源请求成功 || 200：全部资源请求成功
                if (conn.responseCode == 206) {
                    val inputStream = conn.inputStream

                    // 将已创建好的占位文件拿出来
                    val randomAccessFile = RandomAccessFile(File(savePath, getFileName(url)), "rw")

                    // 文件写入的开始位置
                    randomAccessFile.seek(startIndex.toLong())


                    // 将网络数据流写入本地
                    val buffer = ByteArray(1024)
                    var length = -1
                    var total = 0//记录本次下载文件的大小
                    while (true) {
                        length = inputStream.read(buffer)
                        if (0 < length) {
                            randomAccessFile.write(buffer, 0, length)
                            total += length
                            println(threadId.toString() + "已下载" + total)
                            listener.onProgress(threadId, total)
                            /*
                             * 将当前现在到的位置保存到文件中
                             */
                            eachThreadStream.seek(0)
                            eachThreadStream.write(((startIndex + total).toString() + "").toByteArray(charset("UTF-8")))
                        } else break
                    }
                   /* while ((length = inputStream.read(buffer)) > 0) {
                        randomAccessFile.write(buffer, 0, length)
                        total += length
                        println(threadId.toString() + "已下载" + total)
                        listener.onProgress(threadId, total)
                        *//*
                         * 将当前现在到的位置保存到文件中
                         *//*
                        eachThreadStream.seek(0)
                        eachThreadStream.write(((startIndex + total).toString() + "").toByteArray(charset("UTF-8")))
                    }*/

                    eachThreadStream.close()
                    inputStream.close()
                    randomAccessFile.close()
                    cleanTemp(eachThreadFile)//删除临时文件
                    println("线程" + threadId + "下载完毕")
                    listener.onSuc(threadId)
                } else {
                    listener.onErr("响应码是" + conn.responseCode + ". 服务器不支持多线程下载")
                }
            } catch (e: Exception) {
                listener.onErr(e.toString())
            }

        }
    }

    //删除线程产生的临时文件
    @Synchronized private fun cleanTemp(file: File) {
        file.delete()
    }

    //获取下载文件的名称
    private fun getFileName(url: String): String {
        //        return url.substring(url.lastIndexOf("/") + 1);
        return "张国荣,黄耀明 - 这么远 那么近.mp3"
    }


    /**
     * interface of download process
     */
    interface OnDownloadListener {
        fun onSuc(threadId: Int)

        fun onProgress(threadId: Int, progress: Int)

        fun onErr(error: String)
    }
}
