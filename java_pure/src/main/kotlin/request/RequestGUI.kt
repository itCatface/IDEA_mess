package request

import com.alibaba.fastjson.JSON
import com.google.gson.Gson
import net.http.HttpT
import util.net.okhttp.imp.OkHttpT
import java.awt.Color
import java.awt.Insets
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.util.*
import javax.swing.*


object RequestGUI {
    private var GUI_COUNT = 0

    private var frameWidth = 445
    private var frameHeight = 778
    private var frame: JFrame? = null

    @JvmStatic
    fun main(args: Array<String>) {
        openPanel()
    }

    private fun openPanel() {
        GUI_COUNT++
        frame = JFrame("请求GUI${GUI_COUNT}")
        // Setting the width and height of frame
        frame?.setSize(frameWidth, frameHeight)

        frame?.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        /* 创建面板，这个类似于 HTML 的 div 标签
         * 我们可以创建多个面板并在 JFrame 中指定位置
         * 面板中我们可以添加文本字段，按钮及其他组件。
         */
        val panel = JPanel()
        panel.layout = null
        // 添加面板
        frame?.add(panel)
        /*
         * 调用用户定义的方法并添加组件到面板
         */
        placeComponents(panel)

        // 设置界面可见
        frame?.isVisible = true
    }


    private const val hostBtWidth = 60
    private const val hostBtHeight = 25
    private const val hostBtFirstLeft = 2
    private const val hostBtFirstTop = 2

    private const val hostTextWidth = 360
    private const val hostTextHeight = 25
    private const val hostTextFirstLeft = 65
    private const val hostTextFirstTop = 2

    private const val paramTextWidth = 150

    private fun placeComponents(panel: JPanel) {
        /** 1-1. 主机地址 */
        val btHost1 = JButton("主机1=>")
        btHost1.margin = Insets(-2, -25, -2, -25)
        btHost1.setBounds(hostBtFirstLeft, hostBtFirstTop, hostBtWidth, hostBtHeight)
        panel.add(btHost1)
        val textHost1 = JTextField(20)
        textHost1.setBounds(hostTextFirstLeft, hostTextFirstTop, hostTextWidth, hostTextHeight)
        panel.add(textHost1)

        val btHost2 = JButton("主机2=>")
        btHost2.margin = Insets(-2, -25, -2, -25)
        btHost2.setBounds(hostBtFirstLeft, hostBtFirstTop + 30 * 1, hostBtWidth, hostBtHeight)
        panel.add(btHost2)
        val textHost2 = JTextField(20)
        textHost2.setBounds(hostTextFirstLeft, hostTextFirstTop + 30, hostTextWidth, hostTextHeight)
        panel.add(textHost2)

        val btHost3 = JButton("主机3=>")
        btHost3.margin = Insets(-2, -25, -2, -25)
        btHost3.setBounds(hostBtFirstLeft, hostBtFirstTop + 30 * 2, hostBtWidth, hostBtHeight)
        panel.add(btHost3)
        val textHost3 = JTextField(20)
        textHost3.text = "http://127.0.0.1:8080"
        textHost3.setBounds(hostTextFirstLeft, hostTextFirstTop + 30 * 2, hostTextWidth, hostTextHeight)
        panel.add(textHost3)

        /** 1-2. 接口地址 */
        val labelInterface = JLabel("   接  口=>")
        labelInterface.setBounds(hostBtFirstLeft, hostTextFirstTop + 30 * 3 + 8, hostBtWidth, hostBtHeight)
        panel.add(labelInterface)
        val textInterface = JTextField(20)
        textInterface.text = ""
        textInterface.setBounds(hostTextFirstLeft, hostTextFirstTop + 30 * 3 + 8, hostTextWidth, hostBtHeight)
        panel.add(textInterface)

        /** 2-1. 请求结果展示 */
        val textResult = JTextField(20)
        textResult.text = "请求结果展示..."
        textResult.horizontalAlignment = JTextField.LEFT
        textResult.setBounds(2, hostTextFirstTop + 30 * 4 + 16, hostTextWidth + 63, hostBtHeight)
        panel.add(textResult)

        /** 2-2. 功能按钮区域 */
        val btCopy = JButton("复制")
        btCopy.setBounds(hostTextFirstLeft, hostTextFirstTop + 30 * 5 + 16, 60, hostBtHeight)
        panel.add(btCopy)
        val btFormatCopy = JButton("格式")
        btFormatCopy.setBounds(hostTextFirstLeft + 70 * 1, hostTextFirstTop + 30 * 5 + 16, 60, hostBtHeight)
        panel.add(btFormatCopy)
        val btOpenST = JButton("ST")
        btOpenST.setBounds(hostTextFirstLeft + 70 * 2, hostTextFirstTop + 30 * 5 + 16, 60, hostBtHeight)
        panel.add(btOpenST)
        val btDecrypt = JButton("解密")
        btDecrypt.setBounds(hostTextFirstLeft + 70 * 3, hostTextFirstTop + 30 * 5 + 16, 60, hostBtHeight)
        panel.add(btDecrypt)

        /** 1-4. 添加json入参 */
        val textJson = JTextField(20)
        textJson.text = "请添加入参json..."
        textJson.horizontalAlignment = JTextField.LEFT
        textJson.setBounds(2, hostTextFirstTop + 30 * 6 + 16, hostTextWidth - 24, hostBtHeight)
        panel.add(textJson)

        val btRequestJson = JButton("请")
        btRequestJson.setBounds(hostTextFirstLeft + 70 * 4, hostTextFirstTop + 30 * 6 + 16, 60, hostBtHeight)
        panel.add(btRequestJson)

        /** 1-3. 添加入参按钮&开始请求按钮 */
        val btAddRequest = JButton("添加")
        btAddRequest.setBounds(hostTextFirstLeft, hostTextFirstTop + 30 * 7 + 16, 60, hostBtHeight)
        panel.add(btAddRequest)
        val btResetParam = JButton("重置")
        btResetParam.setBounds(hostTextFirstLeft + 70 * 1, hostTextFirstTop + 30 * 7 + 16, 60, hostBtHeight)
        panel.add(btResetParam)
        val btAddParam = JButton("加参")
        btAddParam.setBounds(hostTextFirstLeft + 70 * 2, hostTextFirstTop + 30 * 7 + 16, 60, hostBtHeight)
        panel.add(btAddParam)
        val btRequest = JButton("请求")
        btRequest.setBounds(hostTextFirstLeft + 70 * 3, hostTextFirstTop + 30 * 7 + 16, 60, hostBtHeight)
        panel.add(btRequest)
        val btRequestEncrypt = JButton("密求")
        btRequestEncrypt.setBounds(hostTextFirstLeft + 70 * 4, hostTextFirstTop + 30 * 7 + 16, 60, hostBtHeight)
        panel.add(btRequestEncrypt)

        val labelHostColor = "#00FF00"
        val textHostBackground = "#90EE90"
        btHost1.foreground = Color.decode(labelHostColor)
        textHost1.background = Color.decode(textHostBackground)


        /** 2. 事件处理 */
        var hostPosition = 1
        btHost1.addActionListener {
            hostPosition = 1
            btHost1.foreground = Color.decode(labelHostColor)
            btHost2.foreground = Color.BLACK
            btHost3.foreground = Color.BLACK
            textHost1.background = Color.decode(textHostBackground)
            textHost2.background = Color.WHITE
            textHost3.background = Color.WHITE
        }
        btHost2.addActionListener {
            hostPosition = 2
            btHost1.foreground = Color.BLACK
            btHost2.foreground = Color.decode(labelHostColor)
            btHost3.foreground = Color.BLACK
            textHost1.background = Color.WHITE
            textHost2.background = Color.decode(textHostBackground)
            textHost3.background = Color.WHITE
        }
        btHost3.addActionListener {
            hostPosition = 3
            btHost1.foreground = Color.BLACK
            btHost2.foreground = Color.BLACK
            btHost3.foreground = Color.decode(labelHostColor)
            textHost1.background = Color.WHITE
            textHost2.background = Color.WHITE
            textHost3.background = Color.decode(textHostBackground)
        }


        val paramMap = hashMapOf<JTextField, JTextField>()  // 参数键值输入框
        val map = HashMap<String, String>() // 参数键值对
        var paramLeftCount = 0
        var paramRightCount = 0

        btRequestJson.addActionListener {
            val json = textJson.text.trim()

            var host = when (hostPosition) {
                2 -> textHost2.text
                3 -> textHost3.text
                else -> textHost1.text
            }
            host = if (host.startsWith("http://")) host else "http://$host"

            textResult.text = OkHttpT.getInstance().post("$host/${textInterface.text}", json)
        }

        /* 最下一排 */
        btAddRequest.addActionListener {
            openPanel()
        }

        btResetParam.addActionListener {
            paramMap.iterator().forEach {
                it.key.isVisible = false
                it.value.isVisible = false
            }

            paramMap.clear()
            map.clear()
            paramLeftCount = 0
            paramRightCount = 0
        }

        btAddParam.addActionListener {
            val textParamKey = JTextField(20)
            val textParamValue = JTextField(20)
            if (paramLeftCount < 16) {
                paramLeftCount += 1
                textParamKey.text = " "
                textParamKey.setBounds(2, hostTextFirstTop + 30 * 7 + 16 + paramLeftCount * 30, paramTextWidth, hostBtHeight)
                panel.add(textParamKey)
                textParamValue.text = " "
                textParamValue.setBounds(2 + 20 + paramTextWidth * 1, hostTextFirstTop + 30 * 7 + 16 + paramLeftCount * 30, paramTextWidth, hostBtHeight)
                panel.add(textParamValue)
            } else {
                paramRightCount += 1
                textParamKey.text = " "
                textParamKey.setBounds(2 + 20 + paramTextWidth * 1 + paramTextWidth + 2, hostTextFirstTop + 30 * 7 + 16 + paramRightCount * 30, paramTextWidth, hostBtHeight)
                panel.add(textParamKey)
                textParamValue.text = " "
                textParamValue.setBounds(2 + 20 + paramTextWidth * 1 + paramTextWidth + 2 + 20 + paramTextWidth * 1, hostTextFirstTop + 30 * 7 + 16 + paramRightCount * 30, paramTextWidth, hostBtHeight)
                panel.add(textParamValue)
            }
            paramMap[textParamKey] = textParamValue
        }

        btRequest.addActionListener {
            paramMap.iterator().forEach {
                if (it.key.text.trim().isNotEmpty() && it.value.text.trim().isNotEmpty())
                    map.put(it.key.text.trim(), it.value.text.trim())
            }

            var host = when (hostPosition) {
                2 -> textHost2.text
                3 -> textHost3.text
                else -> textHost1.text
            }

            host = if (host.startsWith("http://")) host else "http://$host"
            textResult.text = HttpT.post("$host/${textInterface.text}", map)
        }

        btRequestEncrypt.addActionListener {
            paramMap.iterator().forEach {
                if (it.key.text.trim().isNotEmpty() && it.value.text.trim().isNotEmpty())
                    map.put(it.key.text.trim(), it.value.text.trim())
            }

            var host = when (hostPosition) {
                2 -> textHost2.text
                3 -> textHost3.text
                else -> textHost1.text
            }

            /** 加密入参 */
            val encrypJson = AESUtil.encrypt(AESUtil.TRANSFER_SEED, Gson().toJson(map))
            val map1 = HashMap<String, String>()
            map1.put(AESUtil.TRANSFER_KEY, encrypJson)
            map1.put("signMethod", "MD5")
            map1.put("signature", AESUtil.toMd5(encrypJson.toByteArray()))

            host = if (host.startsWith("http://")) host else "http://$host"
            textResult.text = HttpT.post("$host/${textInterface.text}", map1)
        }


        btCopy.addActionListener {
            setText2Clipboard(textResult.text)
        }
        btFormatCopy.addActionListener {
            setText2Clipboard(JsonFormat.format(textResult.text))
        }
        btOpenST.addActionListener {
            Runtime.getRuntime().exec("C:\\Program Files (x86)\\Sublime Text 3\\sublime_text.exe")
        }
        btDecrypt.addActionListener {
            textResult.text = AESUtil.decrypt(AESUtil.TRANSFER_SEED, textResult.text)
        }
    }

    fun a() {
        val map = JSON.parse("")
    }


    private fun setText2Clipboard(text: String) {   // 写字符串到剪贴板
        val clip = Toolkit.getDefaultToolkit().systemClipboard
        val content = StringSelection(text)
        clip.setContents(content, null)
    }
}