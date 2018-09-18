package net.retrofit.base.encapsulation

import okhttp3.ResponseBody
import java.io.*

/**
 * Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
object DownloadEngine {

    /* 将流写到本地的工具 */
    fun writeResponseBodyToDisk(body: ResponseBody, filePath: String, listener: OnDownloadListener?): Boolean {

        var inputStream: InputStream? = null
        var outputStream: OutputStream? = null

        try {
            val futureStudioIconFile = File(filePath)

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

                listener?.onProgress(fileSizeDownloaded / fileSize.toFloat())
            }

            outputStream.flush()
            listener?.onSuc()

            return true
        } catch (e: IOException) {
            listener?.onErr(e.toString())
            return false
        } finally {
            if (inputStream != null) inputStream.close()
            if (outputStream != null) outputStream.close()
        }
    }


    /**
     * interface of download process
     */
    interface OnDownloadListener {
        fun onSuc()

        fun onProgress(progress: Float)

        fun onErr(error: String)
    }
}