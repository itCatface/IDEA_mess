package extention

import java.io.*
import java.util.*
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream


fun main(args: Array<String>) {
    fileCopy(File("d:/a/q.txt"), File("d:/a/q_copy.txt"))
}
/**
 * Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 * -
 * v1.0.0
 */
/*****************************************************************
 * 1-1. 文件操作([删除、复制、压缩、写字符串到文件]、读取配置文件) */
fun fileDelete(file: File) { // v1.0.0^删除-->单个文件或整个目录
    if (!file.exists()) return
    if (file.isDirectory) {
        for (f in file.listFiles()) {
            fileDelete(f)
            f.delete()
        }
    }
    file.delete()
}


fun fileCopy(oldFile: File, newFile: File, overwrite: Boolean = false) {    // v1.0.0^复制-->单个文件或仅单个文件夹(默认不覆盖)
    if (!oldFile.exists()) return
//    if (oldFile.exists() and overwrite and newFile.exists()) newFile.delete() else return
    oldFile.copyTo(newFile, overwrite = overwrite, bufferSize = 2048)
}


fun zip(srcFile: File, desFile: File, keepRootDir: Boolean = false, overwrite: Boolean = false) {   // v1.0.0^压缩-->目录(默认不保持根目录 && 不覆盖原有文件)
    if (!srcFile.exists()) return
    when (desFile.exists()) {
        overwrite -> desFile.delete()
        else -> println("dose not overwrite des file")
    }

    val zos = ZipOutputStream(FileOutputStream(desFile))
    if (srcFile.isDirectory) {
        val files = srcFile.listFiles()
        for (fileSec in files) {
            if (keepRootDir) recursionZip(zos, fileSec, srcFile.name + "/")
            else recursionZip(zos, fileSec, "")
        }
    }
    zos.close()
}

private fun recursionZip(zos: ZipOutputStream, file: File, rootDir: String) {
    if (file.isDirectory) {
        val files = file.listFiles()
        for (fileSec in files) {
            recursionZip(zos, fileSec, rootDir + file.name + "/")
        }
    } else {
        val buf = ByteArray(1024)
        val input = FileInputStream(file)
        zos.putNextEntry(ZipEntry(rootDir + file.name))
        var len: Int
        while (true) {
            len = input.read(buf)
            if (len != -1) zos.write(buf, 0, len) else break
        }
        input.close()
    }
}


fun writeStr2File(file: File, content: String, endWrite: Boolean = false) {  // v1.0.0^写字符串到文件(默认不续写)
    if (!file.parentFile.exists()) file.parentFile.mkdirs()
    var bw: BufferedWriter? = null
    try {
        bw = BufferedWriter(FileWriter(file, endWrite)) // 文件不存在会自动新建[但不会创建不存在的父目录]
        bw.write(content)
    } finally {
        bw?.close()
    }
}


/**********************
 * 1-2. 读取配置文件 */
fun setValues(file: File, key: String, value: String) { // v1.0.0^添加配置键值对
    writeStr2File(file, "\n$key=$value", true)
}


fun getValues(file: File, key: String): String {  // v1.0.0^获取指定key的properties值
    val map = getAll(file) ?: return "no file!"
    return if (map.keys.contains(key)) map[key]!! else "no key!"
}


fun getAll(file: File): Map<String, String>? {    // v1.0.0^获取properties文件所有键值对
    val map = HashMap<String, String>()

    var reader: InputStreamReader? = null
    val properties: Properties

    try {
        if (!file.exists()) return null
        reader = InputStreamReader(FileInputStream(file), Charsets.UTF_8)
        properties = Properties()
        properties.load(reader)

        val keySetNew = properties.stringPropertyNames()
        val itrNew = keySetNew.iterator()
        while (itrNew.hasNext()) {
            val key = itrNew.next()
            map[key] = properties.getProperty(key)
        }
        return map
    } finally {
        reader?.close()
    }
}


/******************
 * 2-1. 公共方法 */
fun Closeable.close() {
    try {
        this.close()
    } catch (e: IOException) {
        e.printStackTrace()
    }
}