package net.http

import extention.log
import extention.logNet
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import javax.activation.MimetypesFileTypeMap

/**
 * Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 *
 * 原生HttpURLConnection请求：get | post | 文件上传
 */
object HttpT {

    private const val TME_OUT: Int = 10000

    /* 1. get请求 */
    fun get(url: String, params: Map<String, String>?): String {
        var totalUrl = url   // complete request url

        var result = ""
        var reader: BufferedReader? = null

        try {
            val urlSuffix = ""
            if (null != params) {
                for (key in params.keys) {
                    urlSuffix + (key + "=" + params[key] + "&")
                }
                totalUrl = url + "?" + urlSuffix.substring(0, urlSuffix.length - 1)
            }

            val realUrl = URL(totalUrl)
            val conn = realUrl.openConnection()
            conn.setRequestProperty("accept", "*/*")
            conn.setRequestProperty("connection", "Keep-Alive")
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)")
            conn.connectTimeout = TME_OUT
            conn.readTimeout = TME_OUT
            conn.connect()
            // Map<String, List<String>> map = connection.getHeaderFields();    // getInstance all header fields
            reader = BufferedReader(conn.getInputStream() as InputStreamReader)    // read stream from url
            var line: String
            while (true) {
                line = reader.readLine() ?: break
                result += line
            }

        } catch (e: Exception) {
            result = "get请求失败 :: " + e.toString()

        } finally {
            try {
                if (null != reader) reader.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        return result
    }


    /* 2. post请求 */
    fun post(url: String, params: Map<String, String>?): String {
        if (null != params) logNet(url, params) else logNet(url, mapOf())

        var out: PrintWriter? = null
        var reader: BufferedReader? = null
        var result = ""

        try {
            val realUrl = URL(url)
            val conn = realUrl.openConnection()
            conn.readTimeout = 30000
            conn.connectTimeout = 30000
            conn.setRequestProperty("accept", "*/*")
            conn.setRequestProperty("connection", "Keep-Alive")
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)")
            conn.connectTimeout = TME_OUT
            conn.readTimeout = TME_OUT
            conn.doOutput = true // must set if use post
            conn.doInput = true  // must set if use post
            out = PrintWriter(conn.getOutputStream())

            var totalUrl = ""
            var urlSuffix = ""
            if (null != params && params.isNotEmpty()) {
                for (key in params.keys) {
                    urlSuffix += key + "=" + params[key] + "&"
                }

                totalUrl = urlSuffix.substring(0, urlSuffix.length - 1)
            }

            out.print(totalUrl)

            out.flush()
            reader = BufferedReader(InputStreamReader(conn.getInputStream()))
            var line: String
            while (true) {
                line = reader.readLine() ?: break
                result += line
            }

        } catch (e: Exception) {
            result = "post请求失败 :: " + e.toString()

        } finally {
            try {
                if (out != null) out.close()
                if (reader != null) reader.close()

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        log("$result")
        return result
    }


    /* 3. 上传文件 & 参数 */
    fun upload(url: String, params: Map<String, String>?, fileMap: Map<String, String>?, headers: Map<String, String>?) {
        var totalLength: Long = 0

        if (null != fileMap) {
            for (key in fileMap.keys) {
                totalLength += File(fileMap[key]).totalSpace / 1024  // file size[kb]
                println(totalLength.toString() + "====")
            }
        }

        var os: OutputStream? = null
        var dis: DataInputStream? = null

        var res = ""
        var conn: HttpURLConnection? = null
        val BOUNDARY = "---------------------------123821742118716" // BOUNDARY is delimiter of request headers and uploading files
        try {
            conn = URL(url).openConnection() as HttpURLConnection
            conn.connectTimeout = TME_OUT
            conn.readTimeout = TME_OUT
            conn.doOutput = true
            conn.doInput = true
            conn.useCaches = false
            conn.requestMethod = "POST"

            // headers(cookie)
            if (headers != null) {
                for (key in headers.keys) {
                    conn.addRequestProperty(key, headers[key])
                }
            }

            conn.setRequestProperty("Connection", "Keep-Alive")
            // conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY)

            os = DataOutputStream(conn.outputStream)

            // params
            if (null != params) {
                val sb = StringBuffer()
                for (key in params.keys) {
                    if (null == key) continue
                    sb.append("\r\n").append("--").append(BOUNDARY).append("\r\n")
                    sb.append("Content-Disposition: form-data; name=\"" + key + "\"\r\n\r\n")
                    sb.append(params[key])
                }
                os.write(sb.toString().toByteArray())
            }

            // files
            if (fileMap != null) {
                for (key in fileMap.keys) {
                    if (null == key) continue
                    val file = File(fileMap[key])
                    val filename = file.name
                    var contentType: String? = MimetypesFileTypeMap().getContentType(file)
                    if (filename.endsWith(".png")) {
                        contentType = "image/png"
                    }
                    if (null == contentType || "" == contentType) {
                        contentType = "application/octet-stream"
                    }

                    val sb = StringBuffer()
                    sb.append("\r\n").append("--").append(BOUNDARY).append("\r\n")
                    sb.append("Content-Disposition: form-data; name=\"$key\"; filename=\"$filename\"\r\n")
                    sb.append("Content-Type:" + contentType + "\r\n\r\n")

                    os.write(sb.toString().toByteArray())

                    dis = DataInputStream(FileInputStream(file))
                    var bytes = 0
                    var sum: Long = 0
                    val bufferOut = ByteArray(1024 * 10)
                    while (true) {
                        bytes = dis.read(bufferOut)
                        if (-1 != bytes) {
                            os.write(bufferOut, 0, bytes)

                            sum += bytes.toLong()
                            val progress = (sum * 1.0f / totalLength).toInt()
                            println(sum.toString() + "===" + progress)
                        } else break
                    }

                    dis.close()
                }
            }

            val endData = "\r\n--$BOUNDARY--\r\n".toByteArray()
            os.write(endData)
            os.flush()
            os.close()

            // read the stream content returned from the service
            val buffer = StringBuffer()
            val reader = BufferedReader(InputStreamReader(conn.inputStream))
            var line: String? = null
            while (true) {
                line = reader.readLine() ?: break
                buffer.append(line).append("\n")
            }
            res = buffer.toString()
            println(res)
            reader.close()

        } catch (e: Exception) {
            e.printStackTrace()

        } finally {
            try {
                if (null != dis) dis.close()
                if (null != os) os.close()
                if (conn != null) conn.disconnect()

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}