package request

object JsonFormat {

    /**
     * 1. 格式化json
     */
    private fun getLevelStr(level: Int): String {
        val levelStr = StringBuffer()
        for (levelI in 0 until level) {
            levelStr.append("\t")
        }
        return levelStr.toString()
    }

    fun format(json: String): String {
        var level = 0
        val jsonForMatStr = StringBuffer()
        for (i in 0 until json.length) {

            val ch = json[i]

            if (level > 0 && '\n' == jsonForMatStr[jsonForMatStr.length - 1]) {
                jsonForMatStr.append(getLevelStr(level))
            }

            when (ch) {
                '{', '[' -> {
                    jsonForMatStr.append(ch + "\n")
                    level++
                }
                ',' -> jsonForMatStr.append(ch + "\n")
                '}', ']' -> {
                    jsonForMatStr.append("\n")
                    level--
                    jsonForMatStr.append(getLevelStr(level))
                    jsonForMatStr.append(ch)
                }
                else -> jsonForMatStr.append(ch)
            }
        }

        return jsonForMatStr.toString()
    }


    /**
     * 2. 压缩json
     */
    fun compress(json: String): String {
        return json.trim { it <= ' ' }.replace("\n".toRegex(), "").replace("\t".toRegex(), "")
    }


    @JvmStatic
    fun main(args: Array<String>) {
        var s = "{\"password\":\"测试中文 your password is: 的2\",\"username\":\"测试中文 your username is: 啊1\"}"
        s = "{\"retcode\":\"0\",\"retinfo\":\"成功！\",\"errorCode\":\"0\",\"resultList\":[{\"taocanId\":\"8ace47b960e0a1730160f884cd9859f9\",\"payState\":\"01\",\"price\":\"0\",\"orderNo\":\"YYD20180128005440\",\"signSate\":\"0\",\"cellPhone\":\"15957524678\",\"contracttel\":\"13454481840\",\"constate\":\"03\",\"activeState\":\"0\",\"ceateTime\":\"2018-01-28 21:17:35.0\"},{\"taocanId\":\"8ace47b960e0a1730160f884cd9859f9\",\"payState\":\"02\",\"price\":\"0\",\"orderNo\":\"YYD20180127006168\",\"signSate\":\"1\",\"cellPhone\":\"15957524678\",\"contracttel\":\"13454409253\",\"constate\":\"04\",\"simNo\":\"89860045111751021140\",\"activeState\":\"2\",\"ceateTime\":\"2018-01-27 23:06:43.0\"},{\"taocanId\":\"8ace47b960e0a1730160f884cd9859f9\",\"payState\":\"02\",\"price\":\"0\",\"orderNo\":\"YYD20180125007564\",\"signSate\":\"1\",\"cellPhone\":\"15957524678\",\"contracttel\":\"13454466480\",\"constate\":\"04\",\"simNo\":\"89860045111751020566\",\"activeState\":\"2\",\"ceateTime\":\"2018-01-25 16:05:34.0\"}],\"isSecret\":true,\"errorMsg\":\"成功\",\"errorHint\":\"成功\"}"
        s = "{\"retcode\":\"0\",\"retinfo\":\"成功！\",\"errorCode\":\"0\",\"resultList\":[{\"taocanId\":\"8ace47b960e0a1730160f884cd9859f9\",\"payState\":\"02\",\"price\":\"0\",\"orderNo\":\"YYD20180129007556\",\"signSate\":\"1\",\"cellPhone\":\"15957524678\",\"contracttel\":\"13454406279\",\"constate\":\"03\",\"simNo\":\"89860045111451162995\",\"activeState\":\"2\",\"ceateTime\":\"2018-01-29 21:56:09.0\"},{\"taocanId\":\"8ace47b960e0a1730160f884cd9859f9\",\"payState\":\"01\",\"price\":\"0\",\"orderNo\":\"YYD20180129007540\",\"signSate\":\"0\",\"cellPhone\":\"15957524678\",\"contracttel\":\"13454489495\",\"constate\":\"03\",\"activeState\":\"0\",\"ceateTime\":\"2018-01-29 21:46:39.0\"},{\"taocanId\":\"8ace47b960e0a1730160f884cd9859f9\",\"payState\":\"02\",\"price\":\"0\",\"orderNo\":\"YYD20180127006168\",\"signSate\":\"1\",\"cellPhone\":\"15957524678\",\"contracttel\":\"13454409253\",\"constate\":\"04\",\"simNo\":\"89860045111751021140\",\"activeState\":\"2\",\"ceateTime\":\"2018-01-27 23:06:43.0\"},{\"taocanId\":\"8ace47b960e0a1730160f884cd9859f9\",\"payState\":\"02\",\"price\":\"0\",\"orderNo\":\"YYD20180125007564\",\"signSate\":\"1\",\"cellPhone\":\"15957524678\",\"contracttel\":\"13454466480\",\"constate\":\"04\",\"simNo\":\"89860045111751020566\",\"activeState\":\"2\",\"ceateTime\":\"2018-01-25 16:05:34.0\"}],\"isSecret\":true,\"errorMsg\":\"成功\",\"errorHint\":\"成功\"}"
        s = "{\"retcode\":\"0\",\"retinfo\":\"成功！\",\"errorCode\":\"0\",\"resultList\":[{\"taocanId\":\"8ace47b960e0a1730160f884cd9859f9\",\"payState\":\"02\",\"price\":\"0\",\"orderNo\":\"YYD20180129007556\",\"signSate\":\"1\",\"cellPhone\":\"15957524678\",\"contracttel\":\"13454406279\",\"constate\":\"04\",\"simNo\":\"89860045111451162995\",\"activeState\":\"2\",\"ceateTime\":\"2018-01-29 21:56:09.0\"},{\"taocanId\":\"8ace47b960e0a1730160f884cd9859f9\",\"payState\":\"01\",\"price\":\"0\",\"orderNo\":\"YYD20180129007540\",\"signSate\":\"0\",\"cellPhone\":\"15957524678\",\"contracttel\":\"13454489495\",\"constate\":\"03\",\"activeState\":\"0\",\"ceateTime\":\"2018-01-29 21:46:39.0\"},{\"taocanId\":\"8ace47b960e0a1730160f884cd9859f9\",\"payState\":\"02\",\"price\":\"0\",\"orderNo\":\"YYD20180127006168\",\"signSate\":\"1\",\"cellPhone\":\"15957524678\",\"contracttel\":\"13454409253\",\"constate\":\"04\",\"simNo\":\"89860045111751021140\",\"activeState\":\"2\",\"ceateTime\":\"2018-01-27 23:06:43.0\"},{\"taocanId\":\"8ace47b960e0a1730160f884cd9859f9\",\"payState\":\"02\",\"price\":\"0\",\"orderNo\":\"YYD20180125007564\",\"signSate\":\"1\",\"cellPhone\":\"15957524678\",\"contracttel\":\"13454466480\",\"constate\":\"04\",\"simNo\":\"89860045111751020566\",\"activeState\":\"2\",\"ceateTime\":\"2018-01-25 16:05:34.0\"}],\"isSecret\":true,\"errorMsg\":\"成功\",\"errorHint\":\"成功\"}"
        s = "{\"message\":\"操作成功\",\"code\":\"0\",\"data\":{\"ext\":{\"verifyIdFlag\":\"1\"},\"activeCount\":\"0\",\"userInfo\":{\"resacct\":\"xielinxian\",\"mainLoginName\":\"7CBC69EA93AC5C2F2B0CD5656E367998\",\"userNum\":\"15957524678\",\"isSecret\":true,\"opCountyCode\":\"5714\",\"opId\":\"20039622\",\"opRegionCode\":\"571\",\"retinfo\":\"操作成功\",\"rsp\":\"0\",\"orgId\":\"40055307\",\"sessId\":\"f95nwl5w5slhxctvp8i2lauqchoq0oht\",\"retcode\":\"0\"},\"rc\":\"0\",\"busiInfo\":[{\"id\":0,\"busiId\":\"22222222222222\",\"packageId\":\"2222\",\"brandCode\":\"22222\",\"busiName\":\"开户\",\"busiContent\":\"22222222222222222222222222222222\",\"imgUrl\":\"http://172.31.3.85:9001/image/\\\\1519824646574.png\"},{\"id\":0,\"busiId\":\"8ace47b960e0a1730160f884cd9859f9\",\"packageId\":\"8ace47b960e0a1660160f87c0bbb47ff\",\"brandCode\":\"1000000000050\",\"busiName\":\"开户3\",\"busiContent\":\"33333333333333333333333333\",\"imgUrl\":\"http://172.31.3.85:9001/image/\\\\1519824656484.png\"},{\"id\":0,\"busiId\":\"22222222222\",\"packageId\":\"2222222222\",\"brandCode\":\"2222222222\",\"busiName\":\"开户2\",\"busiContent\":\"2222222222222\",\"imgUrl\":\"http://172.31.3.85:9001/image/\\\\1519831575434.png\"},{\"id\":0,\"busiId\":\"8888888888888\",\"packageId\":\"99999\",\"brandCode\":\"99999999999\",\"busiName\":\"开户4\",\"busiContent\":\"200000000000000000000000000000000000000000\",\"imgUrl\":\"http://172.31.3.85:9001/image/\\\\1519831600568.png\"},{\"id\":0,\"busiId\":\"8ace47bc6176c08e016182e0688e2a14\",\"packageId\":\"8ace47b960e0a1660160f87c0bbb47ff\",\"brandCode\":\"1\",\"busiName\":\"宁波超级视频王\",\"busiContent\":\"标准月费52元，每月含60GB视频流量,视频流量包括30G咪咕爱看省内流量+30G任我看国内流量（可选腾讯、优酷、爱奇艺等app中的一个）并赠送咪咕爱看会员，享省内流量1元1天300M（不使用不收钱）优惠。国内（不含港澳台）语音主叫长市话0.19元/分钟，被叫免费、赠送来电显示\",\"imgUrl\":\"http://172.31.3.85:9001/image/\\\\1519893417642.jpg\"}],\"channelInfo\":{\"isHiddenMenu\":\"true\"},\"cityInfo\":{\"regionName\":\"杭州\",\"provinceName\":\"浙江\",\"countyName\":\"余杭\"},\"active\":\"0\",\"userExt\":{\"qrAlipay\":\"http://172.31.3.85:9001/image/1519975752813.png\",\"qrWx\":\"http://172.31.3.85:9001/image/1519974340274.png\",\"cardNo\":\"32072119910410402X\",\"username\":\"tiger\",\"status\":1,\"name\":\"唐婷\",\"orgId\":\"acbce67d-ed47-4e28-a561-918bfb9910c5\",\"userCards\":[\"32072119910410402X\",\"34012319920830111X\",\"321283199310101826\",\"340406199403181512\",\"321283199310101826\",\"321283199310101826\",\"32072119910410402X\"]},\"totalCount\":\"0\"},\"isLeaf\":true}"
        println(format(s))
        println(compress(format(s)))
    }
}