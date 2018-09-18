package util;


import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import domain.InitData;
import domain.YYJoke341_1;
import design_pattern.single_instance.Normal;
import design_pattern.single_instance.Normal2;
import design_pattern.single_instance.NormalUpgrade;
import design_pattern.single_instance.Simple;
import util.en_decrypt.MD5;
import util.lang.util.DateT;
import util.lang.util.RegexT;
import util.net.retrofit.imp.RetrofitT;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class Test {

    public static void main(String[] args) {

        String url_yy_joke_341_1 = "http://route.showapi.com/341-1/?showapi_appid=51028&showapi_sign=13114fab5f6845f4b65c18b4ba910fa6&maxResult=10";

        RetrofitT.getInstance().post(url_yy_joke_341_1, new HashMap<>(),new RetrofitT.RetrofitCallback() {
            @Override
            public void onSuc(String result) {
                YYJoke341_1 yyJoke341_1 = new Gson().fromJson(result, YYJoke341_1.class);
                System.out.println(yyJoke341_1.getShowapi_res_body().getContentlist().get(0).getText());
            }

            @Override
            public void onErr(String err) {
                System.out.println(err);
            }
        });

        //        Date date = new Date();
        //        System.out.println(System.currentTimeMillis());

        //        JSONObject busiInfo1 = new JSONObject();
        //        busiInfo1.put("id", "0");
        //        busiInfo1.put("busiId", "taocan0");
        //        busiInfo1.put("busiName", "套餐0");
        //        JSONObject busiInfo2 = new JSONObject();
        //        busiInfo2.put("id", "1");
        //        busiInfo2.put("busiId", "taocan1");
        //        busiInfo2.put("busiName", "套餐1");
        //        JSONArray busiInfo = new JSONArray();
        //        busiInfo.add(0, busiInfo1);
        //        busiInfo.add(1, busiInfo2);
        //        JSON.toJSON(busiInfo);
        //        System.out.println(JSON.toJSON(busiInfo));


        //        String s = "080AFFFFFFFFFFFFFFFFFFFF0E0A12170170080004836603";
        //        System.out.println(s.substring(28, 48));


        //        String s = "{\n" +
        //                "  \"message\": \"操作成功\",\n" +
        //                "  \"code\": \"0\",\n" +
        //                "  \"data\": {\n" +
        //                "    \"rc\": \"0\",\n" +
        //                "    \"userInfo\": \"q+iE0huhWeH6SwV3KcBHur37+n1jXEEQUHonQdbY9ePhBHau4KVLsG9IWMRWdC4rShBRNU/fR9gfsYiWy1H3koUdO+LBLyW1JzomKiQL+T0KP9ghUFUerE72O5i/hF3KbP1UCBZ03G/+C51exDFuLSbjdQhwDqx4XPf7HLU32nfn0MXYXlGkG5B9SO2MwjswDa66qV9evaY9pLJzAf3Kl3PJCC0UcC6tg7KdFhf7fmw=\",\n" +
        //                "    \"homeBusType\": [\n" +
        //                "      {\n" +
        //                "        \"busType\": \"自助开卡\",\n" +
        //                "        \"hidden\": false\n" +
        //                "      },\n" +
        //                "      {\n" +
        //                "        \"busType\": \"套卡激活\",\n" +
        //                "        \"hidden\": false\n" +
        //                "      },\n" +
        //                "      {\n" +
        //                "        \"busType\": \"查询\",\n" +
        //                "        \"hidden\": false\n" +
        //                "      }\n" +
        //                "    ],\n" +
        //                "    \"packageList\": [\n" +
        //                "      {\n" +
        //                "        \"id\": 4,\n" +
        //                "        \"mainpriv\": \"pp.gt.fybxl_new.pre\",\n" +
        //                "        \"mainPrivName\": \"新飞跃不限量套餐\",\n" +
        //                "        \"gsm\": \"100分钟\",\n" +
        //                "        \"gprs\": \"流量不限量\",\n" +
        //                "        \"package_message\": \"1.\\t当月使用流量达到10GB限速阈值后，上网速率降至1Mbps以下，次月恢复。当月流量 达100GB后，上网速率降至128Kbps以下，次月恢复。\\n2.\\t本套餐原价78元/月，新入网体验期（前12个月）48元/月，12个月后恢复原价。\\n3.\\t新入网体验期赠送30GB国内定向流量（该流量不计入流量限速规则），900分钟省内主叫国内语音。\\n4.\\t30GB国内定向流量包括以下APP的国内流量：咪咕视频、咪咕直播、咪咕音乐、咪咕游戏、咪咕阅读、咪咕动漫、新浪微博、西瓜视频、今日头条、抖音、快手、搜狐视频、暴风影音、网易云音乐、爱奇艺、手机百度、百度地图、百度输入法、好看视频、百度贴吧、百度文库、百度翻译、百度糯米、百度百科、秒懂百科、哔哩哔哩、百度知道、优酷、芒果、PP视频。\\n5.\\t套餐外资费：国内通话按0.19元/分钟计费，全国被叫免费。\\n6.\\t本套餐流量不限量，其他流量不结转次月，不可叠加其他流量叠加包、加油包、分时包等。\\n7.\\t套餐中的“国内不含港澳台地区，手机上网流量”只适用于4G、3G、2G，不含WLAN（WIFI）上网。\\n8.\\t该活动与线下同产品资费的其他新入网促销活动均互斥，不能同时参与。\\n9.\\t定向流量使用范围：中国移动2G/3G/4G网络下，访问指定视频APP的特定视频内容（其中优酷视频流量包中不含土豆视频，IOS6.5.2或安卓6.5.1及之后版本的视频内容）\\n但不包括以下内容：\\n1、\\t客户端启动、登录及客户端内的图片、文字、视频内插播广告、贪墨、第三方广告、主播类视频、在线观看/下载/缓存第三方视频等。\\n2、\\t手机处于国际或港澳台地区漫游状态下产生的流量。\\n3、\\t利用手机设置代理服务器或VPN等方式，访问APP所产生的流量。\\n4、\\t使用无线上网卡、平板电脑、CPE、MIFI等非手机设备产生的流量。\\n5、\\t手机作为热点使用产生的流量。\\n\",\n" +
        //                "        \"package_flage\": false,\n" +
        //                "        \"package_offering_list\": \"[{\\\"actionType\\\":\\\"A\\\",\\\"offerCode\\\":\\\"pp.gt.fybxl_new.pre\\\",\\\"pofferCode\\\":\\\"\\\",\\\"offerType\\\":\\\"prod\\\"},{\\\"actionType\\\":\\\"A\\\",\\\"offerCode\\\":\\\"gl.base.xfyyy_70B.500\\\",\\\"pofferCode\\\":\\\"\\\",\\\"offerType\\\":\\\"prod\\\"},{\\\"actionType\\\":\\\"A\\\",\\\"offerCode\\\":\\\"gl.base.797118_70B.500\\\",\\\"pofferCode\\\":\\\"gl.base.xfyyy_70B.500\\\",\\\"offerType\\\":\\\"priv\\\"},{\\\"actionType\\\":\\\"A\\\",\\\"offerCode\\\":\\\"gl.base.797122B.500\\\",\\\"pofferCode\\\":\\\"gl.base.xfyyy_70B.500\\\",\\\"offerType\\\":\\\"priv\\\"},{\\\"actionType\\\":\\\"A\\\",\\\"offerCode\\\":\\\"gl.base.601848.500\\\",\\\"pofferCode\\\":\\\"pp.gt.fybxl_new.pre\\\",\\\"offerType\\\":\\\"priv\\\"},{\\\"actionType\\\":\\\"A\\\",\\\"offerCode\\\":\\\"gl.base.602110_797111.500\\\",\\\"pofferCode\\\":\\\"\\\",\\\"offerType\\\":\\\"priv\\\"}]\"\n" +
        //                "      }\n" +
        //                "    ],\n" +
        //                "    \"token\": \"e392023aad20bebd3c4189ea37334b2b\"\n" +
        //                "  },\n" +
        //                "  \"isLeaf\": true\n" +
        //                "}";
        //
        //
        //        s = "{\"message\":\"操作成功\",\"code\":\"0\",\"data\":{\"rc\":\"0\",\"userInfo\":\"q+iE0huhWeH6SwV3KcBHur37+n1jXEEQUHonQdbY9ePhBHau4KVLsG9IWMRWdC4rShBRNU/fR9gfsYiWy1H3koUdO+LBLyW1JzomKiQL+T0KP9ghUFUerE72O5i/hF3KbP1UCBZ03G/+C51exDFuLSbjdQhwDqx4XPf7HLU32nfn0MXYXlGkG5B9SO2MwjswDa66qV9evaY9pLJzAf3Kl3PJCC0UcC6tg7KdFhf7fmw=\",\"homeBusType\":[{\"busType\":\"自助开卡\",\"hidden\":false},{\"busType\":\"套卡激活\",\"hidden\":false},{\"busType\":\"查询\",\"hidden\":false}],\"packageList\":[{\"id\":4,\"mainpriv\":\"pp.gt.fybxl_new.pre\",\"mainPrivName\":\"新飞跃不限量套餐\",\"gsm\":\"100分钟\",\"gprs\":\"流量不限量\",\"package_message\":\"1. 当月使用流量达到10GB限速阈值后，上网速率降至1Mbps以下，次月恢复。当月流量 达100GB后，上网速率降至128Kbps以下，次月恢复。\\n2. 本套餐原价78元/月，新入网体验期（前12个月）48元/月，12个月后恢复原价。\\n3. 新入网体验期赠送30GB国内定向流量（该流量不计入流量限速规则），900分钟省内主叫国内语音。\\n4. 30GB国内定向流量包括以下APP的国内流量：咪咕视频、咪咕直播、咪咕音乐、咪咕游戏、咪咕阅读、咪咕动漫、新浪微博、西瓜视频、今日头条、抖音、快手、搜狐视频、暴风影音、网易云音乐、爱奇艺、手机百度、百度地图、百度输入法、好看视频、百度贴吧、百度文库、百度翻译、百度糯米、百度百科、秒懂百科、哔哩哔哩、百度知道、优酷、芒果、PP视频。\\n5. 套餐外资费：国内通话按0.19元/分钟计费，全国被叫免费。\\n6. 本套餐流量不限量，其他流量不结转次月，不可叠加其他流量叠加包、加油包、分时包等。\\n7. 套餐中的“国内不含港澳台地区，手机上网流量”只适用于4G、3G、2G，不含WLAN（WIFI）上网。\\n8. 该活动与线下同产品资费的其他新入网促销活动均互斥，不能同时参与。\\n9. 定向流量使用范围：中国移动2G/3G/4G网络下，访问指定视频APP的特定视频内容（其中优酷视频流量包中不含土豆视频，IOS6.5.2或安卓6.5.1及之后版本的视频内容）\\n但不包括以下内容：\\n1、 客户端启动、登录及客户端内的图片、文字、视频内插播广告、贪墨、第三方广告、主播类视频、在线观看/下载/缓存第三方视频等。\\n2、 手机处于国际或港澳台地区漫游状态下产生的流量。\\n3、 利用手机设置代理服务器或VPN等方式，访问APP所产生的流量。\\n4、 使用无线上网卡、平板电脑、CPE、MIFI等非手机设备产生的流量。\\n5、 手机作为热点使用产生的流量。\\n\",\"package_flage\":false,\"package_offering_list\":\"[{\\\"actionType\\\":\\\"A\\\",\\\"offerCode\\\":\\\"pp.gt.fybxl_new.pre\\\",\\\"pofferCode\\\":\\\"\\\",\\\"offerType\\\":\\\"prod\\\"},{\\\"actionType\\\":\\\"A\\\",\\\"offerCode\\\":\\\"gl.base.xfyyy_70B.500\\\",\\\"pofferCode\\\":\\\"\\\",\\\"offerType\\\":\\\"prod\\\"},{\\\"actionType\\\":\\\"A\\\",\\\"offerCode\\\":\\\"gl.base.797118_70B.500\\\",\\\"pofferCode\\\":\\\"gl.base.xfyyy_70B.500\\\",\\\"offerType\\\":\\\"priv\\\"},{\\\"actionType\\\":\\\"A\\\",\\\"offerCode\\\":\\\"gl.base.797122B.500\\\",\\\"pofferCode\\\":\\\"gl.base.xfyyy_70B.500\\\",\\\"offerType\\\":\\\"priv\\\"},{\\\"actionType\\\":\\\"A\\\",\\\"offerCode\\\":\\\"gl.base.601848.500\\\",\\\"pofferCode\\\":\\\"pp.gt.fybxl_new.pre\\\",\\\"offerType\\\":\\\"priv\\\"},{\\\"actionType\\\":\\\"A\\\",\\\"offerCode\\\":\\\"gl.base.602110_797111.500\\\",\\\"pofferCode\\\":\\\"\\\",\\\"offerType\\\":\\\"priv\\\"}]\"}],\"token\":\"e392023aad20bebd3c4189ea37334b2b\"},\"isLeaf\":true}";
        //
        //        int i1 = s.indexOf("userInfo\":\"");
        //        int i2 = s.indexOf("\",\"homeBusType");
        //        System.out.println(i1 + " || " + i2);
        //
        //        String s1 = s.substring(s.indexOf(i1), s.indexOf(i2));
        //        System.out.println(s1);


        //        System.out.println(4 % 3);


        //        String s = "{\n" +
        //                "    \"message\": \"操作成功\",\n" +
        //                "    \"code\": \"0\",\n" +
        //                "    \"data\": {\n" +
        //                "        \"rc\": \"0\",\n" +
        //                "        \"userInfo\": {\n" +
        //                "            \"qdCode\": \"SD.LJ\",\n" +
        //                "            \"origion\": \"533\",\n" +
        //                "            \"username\": \"a0Z00001\",\n" +
        //                "            \"orgId\": \"51d4a03a-0a93-42db-934f-8b9f336f8b0c\",\n" +
        //                "            \"orgName\": \"共青团营业厅\"\n" +
        //                "        },\n" +
        //                "        \"homeBusType\": [\n" +
        //                "            {\n" +
        //                "                \"busType\": \"自助开卡\",\n" +
        //                "                \"hidden\": false\n" +
        //                "            }\n" +
        //                "        ],\n" +
        //                "        \"packageList\": [\n" +
        //                "            {\n" +
        //                "                \"id\": 4,\n" +
        //                "                \"mainpriv\": \"pp.gt.fybxl_new.pre\",\n" +
        //                "                \"mainPrivName\": \"新飞跃不限量套餐\",\n" +
        //                "                \"gsm\": \"100分钟\",\n" +
        //                "                \"gprs\": \"流量不限量\",\n" +
        //                "                \"package_message\": \"1.\\t当月使用流量达到10GB限速阈值后，上网速率降至1Mbps以下，次月恢复。当月流量 达100GB后，上网速率降至128Kbps以下，次月恢复。\\n2.\\t本套餐原价78元/月，新入网体验期（前12个月）48元/月，12个月后恢复原价。\\n3.\\t新入网体验期赠送30GB国内定向流量（该流量不计入流量限速规则），900分钟省内主叫国内语音。\\n4.\\t30GB国内定向流量包括以下APP的国内流量：咪咕视频、咪咕直播、咪咕音乐、咪咕游戏、咪咕阅读、咪咕动漫、新浪微博、西瓜视频、今日头条、抖音、快手、搜狐视频、暴风影音、网易云音乐、爱奇艺、手机百度、百度地图、百度输入法、好看视频、百度贴吧、百度文库、百度翻译、百度糯米、百度百科、秒懂百科、哔哩哔哩、百度知道、优酷、芒果、PP视频。\\n5.\\t套餐外资费：国内通话按0.19元/分钟计费，全国被叫免费。\\n6.\\t本套餐流量不限量，其他流量不结转次月，不可叠加其他流量叠加包、加油包、分时包等。\\n7.\\t套餐中的“国内不含港澳台地区，手机上网流量”只适用于4G、3G、2G，不含WLAN（WIFI）上网。\\n8.\\t该活动与线下同产品资费的其他新入网促销活动均互斥，不能同时参与。\\n9.\\t定向流量使用范围：中国移动2G/3G/4G网络下，访问指定视频APP的特定视频内容（其中优酷视频流量包中不含土豆视频，IOS6.5.2或安卓6.5.1及之后版本的视频内容）\\n但不包括以下内容：\\n1、\\t客户端启动、登录及客户端内的图片、文字、视频内插播广告、贪墨、第三方广告、主播类视频、在线观看/下载/缓存第三方视频等。\\n2、\\t手机处于国际或港澳台地区漫游状态下产生的流量。\\n3、\\t利用手机设置代理服务器或VPN等方式，访问APP所产生的流量。\\n4、\\t使用无线上网卡、平板电脑、CPE、MIFI等非手机设备产生的流量。\\n5、\\t手机作为热点使用产生的流量。\\n\",\n" +
        //                "                \"package_flage\": false,\n" +
        //                "                \"package_offering_list\": \"[{\\\"actionType\\\":\\\"A\\\",\\\"offerCode\\\":\\\"pp.gt.fybxl_new.pre\\\",\\\"pofferCode\\\":\\\"\\\",\\\"offerType\\\":\\\"prod\\\"},{\\\"actionType\\\":\\\"A\\\",\\\"offerCode\\\":\\\"gl.base.xfyyy_70B.500\\\",\\\"pofferCode\\\":\\\"\\\",\\\"offerType\\\":\\\"prod\\\"},{\\\"actionType\\\":\\\"A\\\",\\\"offerCode\\\":\\\"gl.base.797118_70B.500\\\",\\\"pofferCode\\\":\\\"gl.base.xfyyy_70B.500\\\",\\\"offerType\\\":\\\"priv\\\"},{\\\"actionType\\\":\\\"A\\\",\\\"offerCode\\\":\\\"gl.base.797122B.500\\\",\\\"pofferCode\\\":\\\"gl.base.xfyyy_70B.500\\\",\\\"offerType\\\":\\\"priv\\\"},{\\\"actionType\\\":\\\"A\\\",\\\"offerCode\\\":\\\"gl.base.601848.500\\\",\\\"pofferCode\\\":\\\"pp.gt.fybxl_new.pre\\\",\\\"offerType\\\":\\\"priv\\\"},{\\\"actionType\\\":\\\"A\\\",\\\"offerCode\\\":\\\"gl.base.602110_797111.500\\\",\\\"pofferCode\\\":\\\"\\\",\\\"offerType\\\":\\\"priv\\\"}]\"\n" +
        //                "            }\n" +
        //                "        ],\n" +
        //                "        \"token\": \"ab2c94be2fd9f030d1d4d3aeeabc4177\"\n" +
        //                "    },\n" +
        //                "    \"isLeaf\": true\n" +
        //                "}";
        //        s = "{\n" + "    \"message\":\"操作成功\",\n" + "    \"code\":\"0\",\n" + "    \"data\":{\n" + "        \"rc\":\"0\",\n" + "        \"userInfo\":{\n" + "            \"qdCode\":\"SD.LJ\",\n" + "            \"origion\":\"533\",\n" + "            \"username\":\"a0Z00001\",\n" + "            \"orgId\":\"51d4a03a-0a93-42db-934f-8b9f336f8b0c\",\n" + "            \"orgName\":\"共青团营业厅\"\n" + "        },\n" + "        \"homeBusType\":[\n" + "            {\n" + "                \"busType\":\"自助开卡\",\n" + "                \"hidden\":false\n" + "            }\n" + "        ],\n" + "        \"packageList\":[\n" + "            {\n" + "                \"id\":4,\n" + "                \"mainpriv\":\"pp.gt.fybxl_new.pre\",\n" + "                \"mainPrivName\":\"新飞跃不限量套餐\",\n" + "                \"gsm\":\"100分钟\",\n" + "                \"gprs\":\"流量不限量\",\n" + "                \"package_message\":\"1.\t当月使用流量达到10GB限速阈值后，上网速率降至1Mbps以下，次月恢复。当月流量 达100GB后，上网速率降至128Kbps以下，次月恢复。\n" + "2.\t本套餐原价78元/月，新入网体验期（前12个月）48元/月，12个月后恢复原价。\n" + "3.\t新入网体验期赠送30GB国内定向流量（该流量不计入流量限速规则），900分钟省内主叫国内语音。\n" + "4.\t30GB国内定向流量包括以下APP的国内流量：咪咕视频、咪咕直播、咪咕音乐、咪咕游戏、咪咕阅读、咪咕动漫、新浪微博、西瓜视频、今日头条、抖音、快手、搜狐视频、暴风影音、网易云音乐、爱奇艺、手机百度、百度地图、百度输入法、好看视频、百度贴吧、百度文库、百度翻译、百度糯米、百度百科、秒懂百科、哔哩哔哩、百度知道、优酷、芒果、PP视频。\n" + "5.\t套餐外资费：国内通话按0.19元/分钟计费，全国被叫免费。\n" + "6.\t本套餐流量不限量，其他流量不结转次月，不可叠加其他流量叠加包、加油包、分时包等。\n" + "7.\t套餐中的“国内不含港澳台地区，手机上网流量”只适用于4G、3G、2G，不含WLAN（WIFI）上网。\n" + "8.\t该活动与线下同产品资费的其他新入网促销活动均互斥，不能同时参与。\n" + "9.\t定向流量使用范围：中国移动2G/3G/4G网络下，访问指定视频APP的特定视频内容（其中优酷视频流量包中不含土豆视频，IOS6.5.2或安卓6.5.1及之后版本的视频内容）\n" + "但不包括以下内容：\n" + "1、\t客户端启动、登录及客户端内的图片、文字、视频内插播广告、贪墨、第三方广告、主播类视频、在线观看/下载/缓存第三方视频等。\n" + "2、\t手机处于国际或港澳台地区漫游状态下产生的流量。\n" + "3、\t利用手机设置代理服务器或VPN等方式，访问APP所产生的流量。\n" + "4、\t使用无线上网卡、平板电脑、CPE、MIFI等非手机设备产生的流量。\n" + "5、\t手机作为热点使用产生的流量。\n" + "\",\n" + "                \"package_flage\":false,\n" + "                \"package_offering_list\":\"[{\"actionType\":\"A\",\"offerCode\":\"pp.gt.fybxl_new.pre\",\"pofferCode\":\"\",\"offerType\":\"prod\"},{\"actionType\":\"A\",\"offerCode\":\"gl.base.xfyyy_70B.500\",\"pofferCode\":\"\",\"offerType\":\"prod\"},{\"actionType\":\"A\",\"offerCode\":\"gl.base.797118_70B.500\",\"pofferCode\":\"gl.base.xfyyy_70B.500\",\"offerType\":\"priv\"},{\"actionType\":\"A\",\"offerCode\":\"gl.base.797122B.500\",\"pofferCode\":\"gl.base.xfyyy_70B.500\",\"offerType\":\"priv\"},{\"actionType\":\"A\",\"offerCode\":\"gl.base.601848.500\",\"pofferCode\":\"pp.gt.fybxl_new.pre\",\"offerType\":\"priv\"},{\"actionType\":\"A\",\"offerCode\":\"gl.base.602110_797111.500\",\"pofferCode\":\"\",\"offerType\":\"priv\"}]\"\n" + "            },\n" + "            {\n" + "                \"id\":4,\n" + "                \"mainpriv\":\"pp.gt.fybxl_new.pre\",\n" + "                \"mainPrivName\":\"新飞跃不限量套餐\",\n" + "                \"gsm\":\"100分钟\",\n" + "                \"gprs\":\"流量不限量\",\n" + "                \"package_message\":\"1.\t当月使用流量达到10GB限速阈值后，上网速率降至1Mbps以下，次月恢复。当月流量 达100GB后，上网速率降至128Kbps以下，次月恢复。\n" + "2.\t本套餐原价78元/月，新入网体验期（前12个月）48元/月，12个月后恢复原价。\n" + "3.\t新入网体验期赠送30GB国内定向流量（该流量不计入流量限速规则），900分钟省内主叫国内语音。\n" + "4.\t30GB国内定向流量包括以下APP的国内流量：咪咕视频、咪咕直播、咪咕音乐、咪咕游戏、咪咕阅读、咪咕动漫、新浪微博、西瓜视频、今日头条、抖音、快手、搜狐视频、暴风影音、网易云音乐、爱奇艺、手机百度、百度地图、百度输入法、好看视频、百度贴吧、百度文库、百度翻译、百度糯米、百度百科、秒懂百科、哔哩哔哩、百度知道、优酷、芒果、PP视频。\n" + "5.\t套餐外资费：国内通话按0.19元/分钟计费，全国被叫免费。\n" + "6.\t本套餐流量不限量，其他流量不结转次月，不可叠加其他流量叠加包、加油包、分时包等。\n" + "7.\t套餐中的“国内不含港澳台地区，手机上网流量”只适用于4G、3G、2G，不含WLAN（WIFI）上网。\n" + "8.\t该活动与线下同产品资费的其他新入网促销活动均互斥，不能同时参与。\n" + "9.\t定向流量使用范围：中国移动2G/3G/4G网络下，访问指定视频APP的特定视频内容（其中优酷视频流量包中不含土豆视频，IOS6.5.2或安卓6.5.1及之后版本的视频内容）\n" + "但不包括以下内容：\n" + "1、\t客户端启动、登录及客户端内的图片、文字、视频内插播广告、贪墨、第三方广告、主播类视频、在线观看/下载/缓存第三方视频等。\n" + "2、\t手机处于国际或港澳台地区漫游状态下产生的流量。\n" + "3、\t利用手机设置代理服务器或VPN等方式，访问APP所产生的流量。\n" + "4、\t使用无线上网卡、平板电脑、CPE、MIFI等非手机设备产生的流量。\n" + "5、\t手机作为热点使用产生的流量。\n" + "\",\n" + "                \"package_flage\":false,\n" + "                \"package_offering_list\":\"[{\"actionType\":\"A\",\"offerCode\":\"pp.gt.fybxl_new.pre\",\"pofferCode\":\"\",\"offerType\":\"prod\"},{\"actionType\":\"A\",\"offerCode\":\"gl.base.xfyyy_70B.500\",\"pofferCode\":\"\",\"offerType\":\"prod\"},{\"actionType\":\"A\",\"offerCode\":\"gl.base.797118_70B.500\",\"pofferCode\":\"gl.base.xfyyy_70B.500\",\"offerType\":\"priv\"},{\"actionType\":\"A\",\"offerCode\":\"gl.base.797122B.500\",\"pofferCode\":\"gl.base.xfyyy_70B.500\",\"offerType\":\"priv\"},{\"actionType\":\"A\",\"offerCode\":\"gl.base.601848.500\",\"pofferCode\":\"pp.gt.fybxl_new.pre\",\"offerType\":\"priv\"},{\"actionType\":\"A\",\"offerCode\":\"gl.base.602110_797111.500\",\"pofferCode\":\"\",\"offerType\":\"priv\"}]\"\n" + "            },\n" + "            {\n" + "                \"id\":4,\n" + "                \"mainpriv\":\"pp.gt.fybxl_new.pre\",\n" + "                \"mainPrivName\":\"新飞跃不限量套餐\",\n" + "                \"gsm\":\"100分钟\",\n" + "                \"gprs\":\"流量不限量\",\n" + "                \"package_message\":\"1.\t当月使用流量达到10GB限速阈值后，上网速率降至1Mbps以下，次月恢复。当月流量 达100GB后，上网速率降至128Kbps以下，次月恢复。\n" + "2.\t本套餐原价78元/月，新入网体验期（前12个月）48元/月，12个月后恢复原价。\n" + "3.\t新入网体验期赠送30GB国内定向流量（该流量不计入流量限速规则），900分钟省内主叫国内语音。\n" + "4.\t30GB国内定向流量包括以下APP的国内流量：咪咕视频、咪咕直播、咪咕音乐、咪咕游戏、咪咕阅读、咪咕动漫、新浪微博、西瓜视频、今日头条、抖音、快手、搜狐视频、暴风影音、网易云音乐、爱奇艺、手机百度、百度地图、百度输入法、好看视频、百度贴吧、百度文库、百度翻译、百度糯米、百度百科、秒懂百科、哔哩哔哩、百度知道、优酷、芒果、PP视频。\n" + "5.\t套餐外资费：国内通话按0.19元/分钟计费，全国被叫免费。\n" + "6.\t本套餐流量不限量，其他流量不结转次月，不可叠加其他流量叠加包、加油包、分时包等。\n" + "7.\t套餐中的“国内不含港澳台地区，手机上网流量”只适用于4G、3G、2G，不含WLAN（WIFI）上网。\n" + "8.\t该活动与线下同产品资费的其他新入网促销活动均互斥，不能同时参与。\n" + "9.\t定向流量使用范围：中国移动2G/3G/4G网络下，访问指定视频APP的特定视频内容（其中优酷视频流量包中不含土豆视频，IOS6.5.2或安卓6.5.1及之后版本的视频内容）\n" + "但不包括以下内容：\n" + "1、\t客户端启动、登录及客户端内的图片、文字、视频内插播广告、贪墨、第三方广告、主播类视频、在线观看/下载/缓存第三方视频等。\n" + "2、\t手机处于国际或港澳台地区漫游状态下产生的流量。\n" + "3、\t利用手机设置代理服务器或VPN等方式，访问APP所产生的流量。\n" + "4、\t使用无线上网卡、平板电脑、CPE、MIFI等非手机设备产生的流量。\n" + "5、\t手机作为热点使用产生的流量。\n" + "\",\n" + "                \"package_flage\":false,\n" + "                \"package_offering_list\":\"[{\"actionType\":\"A\",\"offerCode\":\"pp.gt.fybxl_new.pre\",\"pofferCode\":\"\",\"offerType\":\"prod\"},{\"actionType\":\"A\",\"offerCode\":\"gl.base.xfyyy_70B.500\",\"pofferCode\":\"\",\"offerType\":\"prod\"},{\"actionType\":\"A\",\"offerCode\":\"gl.base.797118_70B.500\",\"pofferCode\":\"gl.base.xfyyy_70B.500\",\"offerType\":\"priv\"},{\"actionType\":\"A\",\"offerCode\":\"gl.base.797122B.500\",\"pofferCode\":\"gl.base.xfyyy_70B.500\",\"offerType\":\"priv\"},{\"actionType\":\"A\",\"offerCode\":\"gl.base.601848.500\",\"pofferCode\":\"pp.gt.fybxl_new.pre\",\"offerType\":\"priv\"},{\"actionType\":\"A\",\"offerCode\":\"gl.base.602110_797111.500\",\"pofferCode\":\"\",\"offerType\":\"priv\"}]\"\n" + "            },\n" + "            {\n" + "                \"id\":4,\n" + "                \"mainpriv\":\"pp.gt.fybxl_new.pre\",\n" + "                \"mainPrivName\":\"新飞跃不限量套餐\",\n" + "                \"gsm\":\"100分钟\",\n" + "                \"gprs\":\"流量不限量\",\n" + "                \"package_message\":\"1.\t当月使用流量达到10GB限速阈值后，上网速率降至1Mbps以下，次月恢复。当月流量 达100GB后，上网速率降至128Kbps以下，次月恢复。\n" + "2.\t本套餐原价78元/月，新入网体验期（前12个月）48元/月，12个月后恢复原价。\n" + "3.\t新入网体验期赠送30GB国内定向流量（该流量不计入流量限速规则），900分钟省内主叫国内语音。\n" + "4.\t30GB国内定向流量包括以下APP的国内流量：咪咕视频、咪咕直播、咪咕音乐、咪咕游戏、咪咕阅读、咪咕动漫、新浪微博、西瓜视频、今日头条、抖音、快手、搜狐视频、暴风影音、网易云音乐、爱奇艺、手机百度、百度地图、百度输入法、好看视频、百度贴吧、百度文库、百度翻译、百度糯米、百度百科、秒懂百科、哔哩哔哩、百度知道、优酷、芒果、PP视频。\n" + "5.\t套餐外资费：国内通话按0.19元/分钟计费，全国被叫免费。\n" + "6.\t本套餐流量不限量，其他流量不结转次月，不可叠加其他流量叠加包、加油包、分时包等。\n" + "7.\t套餐中的“国内不含港澳台地区，手机上网流量”只适用于4G、3G、2G，不含WLAN（WIFI）上网。\n" + "8.\t该活动与线下同产品资费的其他新入网促销活动均互斥，不能同时参与。\n" + "9.\t定向流量使用范围：中国移动2G/3G/4G网络下，访问指定视频APP的特定视频内容（其中优酷视频流量包中不含土豆视频，IOS6.5.2或安卓6.5.1及之后版本的视频内容）\n" + "但不包括以下内容：\n" + "1、\t客户端启动、登录及客户端内的图片、文字、视频内插播广告、贪墨、第三方广告、主播类视频、在线观看/下载/缓存第三方视频等。\n" + "2、\t手机处于国际或港澳台地区漫游状态下产生的流量。\n" + "3、\t利用手机设置代理服务器或VPN等方式，访问APP所产生的流量。\n" + "4、\t使用无线上网卡、平板电脑、CPE、MIFI等非手机设备产生的流量。\n" + "5、\t手机作为热点使用产生的流量。\n" + "\",\n" + "                \"package_flage\":false,\n" + "                \"package_offering_list\":\"[{\"actionType\":\"A\",\"offerCode\":\"pp.gt.fybxl_new.pre\",\"pofferCode\":\"\",\"offerType\":\"prod\"},{\"actionType\":\"A\",\"offerCode\":\"gl.base.xfyyy_70B.500\",\"pofferCode\":\"\",\"offerType\":\"prod\"},{\"actionType\":\"A\",\"offerCode\":\"gl.base.797118_70B.500\",\"pofferCode\":\"gl.base.xfyyy_70B.500\",\"offerType\":\"priv\"},{\"actionType\":\"A\",\"offerCode\":\"gl.base.797122B.500\",\"pofferCode\":\"gl.base.xfyyy_70B.500\",\"offerType\":\"priv\"},{\"actionType\":\"A\",\"offerCode\":\"gl.base.601848.500\",\"pofferCode\":\"pp.gt.fybxl_new.pre\",\"offerType\":\"priv\"},{\"actionType\":\"A\",\"offerCode\":\"gl.base.602110_797111.500\",\"pofferCode\":\"\",\"offerType\":\"priv\"}]\"\n" + "            }\n" + "        ],\n" + "        \"token\":\"ab2c94be2fd9f030d1d4d3aeeabc4177\"\n" + "    },\n" + "    \"isLeaf\":true\n" + "}";
        //
        //        s = FileT.read("C:\\Users\\Administrator\\Desktop\\lo.txt");
        //
        //        No4ALogin no4ALogin = new Gson().fromJson(s, No4ALogin.class);
        //        System.out.println(no4ALogin.getData().getPackageList().get(0).getGprs());


        //        No4ALogin.Data.PackageList o = GsonT.fromToJson(s, new TypeToken<List<No4ALogin.Data.PackageList>>() {}.getType());
        //        System.out.println(o.getGprs());


        //        yys.iflytek.mobilesd.module.start.domain.No4ALogin no4ALogin = new Gson().fromJson(s, yys.iflytek.mobilesd.module.start.domain.No4ALogin.class);
        //        System.out.println(no4ALogin.getCode());

        ////        String s = "{\"message\":\"操作成功\",\"code\":\"0\",\"data\":{\"phoneNumList\":[{\"servNum\":\"19853158024\",\"prepay\":\"0\",\"orgId\":\"\",\"origion\":\"531\",\"seqnum\":\"1\",\"minPrePay\":\"0\",\"minCost\":\"0\"},{\"servNum\":\"19853158034\",\"prepay\":\"0\",\"orgId\":\"\",\"origion\":\"531\",\"seqnum\":\"2\",\"minPrePay\":\"0\",\"minCost\":\"0\"},{\"servNum\":\"19853158042\",\"prepay\":\"0\",\"orgId\":\"\",\"origion\":\"531\",\"seqnum\":\"3\",\"minPrePay\":\"0\",\"minCost\":\"0\"},{\"servNum\":\"19853159014\",\"prepay\":\"0\",\"orgId\":\"\",\"origion\":\"531\",\"seqnum\":\"4\",\"minPrePay\":\"0\",\"minCost\":\"0\"},{\"servNum\":\"19853159024\",\"prepay\":\"0\",\"orgId\":\"\",\"origion\":\"531\",\"seqnum\":\"5\",\"minPrePay\":\"0\",\"minCost\":\"0\"},{\"servNum\":\"19853159032\",\"prepay\":\"0\",\"orgId\":\"\",\"origion\":\"531\",\"seqnum\":\"6\",\"minPrePay\":\"0\",\"minCost\":\"0\"},{\"servNum\":\"19853159034\",\"prepay\":\"0\",\"orgId\":\"\",\"origion\":\"531\",\"seqnum\":\"7\",\"minPrePay\":\"0\",\"minCost\":\"0\"},{\"servNum\":\"19853159041\",\"prepay\":\"0\",\"orgId\":\"\",\"origion\":\"531\",\"seqnum\":\"8\",\"minPrePay\":\"0\",\"minCost\":\"0\"},{\"servNum\":\"19853159042\",\"prepay\":\"0\",\"orgId\":\"\",\"origion\":\"531\",\"seqnum\":\"9\",\"minPrePay\":\"0\",\"minCost\":\"0\"},{\"servNum\":\"19853159043\",\"prepay\":\"0\",\"orgId\":\"\",\"origion\":\"531\",\"seqnum\":\"10\",\"minPrePay\":\"0\",\"minCost\":\"0\"}]}}";
        //        String s = "{\"message\":\"操作成功\",\"code\":\"0\",\"data\":{\"phoneNumList\":[{\"servNum\":\"19853158024\",\"prepay\":\"0\",\"orgId\":\"\",\"origion\":\"531\",\"seqnum\":\"1\",\"minPrePay\":\"0\",\"minCost\":\"0\"},{\"servNum\":\"19853158034\",\"prepay\":\"0\",\"orgId\":\"\",\"origion\":\"531\",\"seqnum\":\"2\",\"minPrePay\":\"0\",\"minCost\":\"0\"},{\"servNum\":\"19853158042\",\"prepay\":\"0\",\"orgId\":\"\",\"origion\":\"531\",\"seqnum\":\"3\",\"minPrePay\":\"0\",\"minCost\":\"0\"},{\"servNum\":\"19853159014\",\"prepay\":\"0\",\"orgId\":\"\",\"origion\":\"531\",\"seqnum\":\"4\",\"minPrePay\":\"0\",\"minCost\":\"0\"},{\"servNum\":\"19853159024\",\"prepay\":\"0\",\"orgId\":\"\",\"origion\":\"531\",\"seqnum\":\"5\",\"minPrePay\":\"0\",\"minCost\":\"0\"},{\"servNum\":\"19853159032\",\"prepay\":\"0\",\"orgId\":\"\",\"origion\":\"531\",\"seqnum\":\"6\",\"minPrePay\":\"0\",\"minCost\":\"0\"},{\"servNum\":\"19853159034\",\"prepay\":\"0\",\"orgId\":\"\",\"origion\":\"531\",\"seqnum\":\"7\",\"minPrePay\":\"0\",\"minCost\":\"0\"},{\"servNum\":\"19853159041\",\"prepay\":\"0\",\"orgId\":\"\",\"origion\":\"531\",\"seqnum\":\"8\",\"minPrePay\":\"0\",\"minCost\":\"0\"},{\"servNum\":\"19853159042\",\"prepay\":\"0\",\"orgId\":\"\",\"origion\":\"531\",\"seqnum\":\"9\",\"minPrePay\":\"0\",\"minCost\":\"0\"},{\"servNum\":\"19853159043\",\"prepay\":\"0\",\"orgId\":\"\",\"origion\":\"531\",\"seqnum\":\"10\",\"minPrePay\":\"0\",\"minCost\":\"0\"}]}}\n";
        //        PhoneNumListBean phoneNumListBean = new Gson().fromJson(s, PhoneNumListBean.class);
        //        System.out.println(phoneNumListBean.getData().getPhoneNumList().toString());

        //        int i = 5;
        //        System.out.println(i /3.0);


        //        String s = "20140524";
        //        s = s.substring(0, 4) + "-" + s.substring(4, 6) + "-" + s.substring(6);
        //        System.out.println(s);

        //        String result = "13012892925";
        //
        //        result = result.substring(0, 3) + " " + result.substring(3, 7) + " " + result.substring(7);
        //        System.out.println(result);

        //        boolean b = Pattern.compile("^1\\d{10}$").matcher(result.trim()).find();
        //        System.out.println(b);


       /* Map<String, String> map = new HashMap<>();

        try {
            File file = new File("D:\\下载\\lol_names.txt");
            FileInputStream fis = new FileInputStream(file);
            //            BufferedInputStream bis = new BufferedInputStream(fis);
            FileReader reader = new FileReader(file);
            BufferedReader reader1 = new BufferedReader(reader);
            String line;
            while ((line = reader1.readLine()) != null) {
                if (line.contains("："))
                    map.put(line.substring(line.indexOf("：") + 1, line.indexOf("(")), line.substring(line.indexOf("(") + 1, line.indexOf(")")));

            }

            System.out.println(map.toString());

        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {

        }*/


        //        byte[] b1 = new byte[1024];
        //        byte[] b2 = new byte[1024];
        //        System.out.println(b1.toString() + "---" + new String(b1));

        //        System.out.println(b1 + " || " + new String(b1));
        //        System.out.println(new String(b1) + "\r\n" + new String(b2));


        //        System.out.println(DateT.netTimeStamp());
        //
        //        String t = new SimpleDateFormat("yyyy").format(DateT.netTimeStamp());
        //        System.out.println(t);
        //
        //        HttpT.getInstance().setT("111");
        //        System.out.println(Thread.currentThread().getName());
        //
        //
        //
        //        String json = "{'name':'catface', 'age':'27'}";
        //
        //        Map<String, String> map = new HashMap<>();
        //        map.put("id", "111");
        //        map.put("name", "catface");
        //        map.put("sex", "male");
        //
        //        Map<String, String> userMap = new HashMap<>();
        //        userMap.put("username", "catface");
        //        userMap.put("password", "测试root");
        //
        //        Map<String, String> fileMap = new HashMap<>();
        //        fileMap.put("file", "d:/flag.txt");
        //        fileMap.put("file2", "d:/d.txt");
        //        fileMap.put("file3", "d:/log111.txt");
        //        fileMap.put("file4", "d:/log222.txt");
        //        fileMap.put("file4", "d:/a");

        //        map.clear();
        //        map.put("idActivity", "6");
        //        System.out.println(HttpT.getInstance().post("http://10.5.19.25:8022/SpringBootAPI/RechargeActivity/findLevel", AESUtil.encrypt(AESUtil.TRANSFER_SEED, map)));
        //        map.put("code", "571");
        //        System.out.println(HttpT.getInstance().post("http://10.5.19.25:8022/SpringBootAPI/RechargeActivity/findActivityByCode", map));

        //        String get = HttpT.getInstance().get("http://127.0.0.1:8080/hi/register", null);
        //        String get = HttpT.getInstance().get("http://127.0.0.1:8080/test/register", map);
        //        HttpT.getInstance().post("http://127.0.0.1:8080/test/login", userMap);
        //        HttpT.getInstance().post("http://127.0.0.1:8080/test/postJson", JSON.toJSONString(map));


        //        String upload = HttpT.getInstance().upload("http://127.0.0.1:8080/hi/uploadFileBySpringAndFileName", map, fileMap, null);
        //        HttpT.getInstance().upload("http://127.0.0.1:8080/test/upload", map, fileMap);
        //        String upload = HttpT.getInstance().upload("http://127.0.0.1:8080/hi/uploadFileBySpringAndFileName",null, "d:/d.txt");
        //        String upload = HttpT.getInstance().upload("http://127.0.0.1:8080/test/upload", "D:\\test_dir.7z");
        //        System.out.println(upload);

        //        String download = HttpT.getInstance().download("http://128.0.0.1:8080/hi/downloadFile", "d:/", "zgr.mp3");
        //        System.out.println(download);


        //        new MTDownloadT("http://dldir1.qq.com/qqyy/pc/QQPlayer_Setup_39_936.exe", "d:/", 3).download(new MTDownloadT.OnDownloadListener() {
        //        new MTDownloadT("http://127.0.0.1:8080/hi/downloadFile", "d:/", 3).download(new MTDownloadT.OnDownloadListener() {
        //            @Override
        //            public void onSuc(int threadId) {
        //
        //            }
        //
        //            @Override
        //            public void onProgress(int threadId, int progress) {
        //                System.out.println(threadId + "||" + progress);
        //            }
        //
        //            @Override
        //            public void onErr(String error) {
        //
        //            }
        //        });


        //        OkHttpT.getInstance().get("http://10.5.119.89:8080/iflytek/app/app/getVersion", new OkHttpT.OKCallback() {
        //        OkHttpT.getInstance().get("http://127.0.0.1:8080/hi/register",json, new OkHttpT.OKCallback() {
        //        OkHttpT.getInstance().get("http://127.0.0.1:8080/hi/register", userMap, new OkHttpT.OKCallback() {
        //        OkHttpT.getInstance().post("http://127.0.0.1:8080/hi/register", map, new OkHttpT.OKCallback() {
        //        OkHttpT.getInstance().upload("http://127.0.0.1:8080/hi/uploadFileBySpringAndFileName", map, fileMap, new OkHttpT.OKCallback() {
        //        OkHttpT.getInstance().download("http://127.0.0.1:8080/hi/downloadFile", "d:/a_test_dir","aaa.jpg", new OkHttpT.OKCallback() {
        //        OkHttpT.getInstance().upload("http://10.5.119.89:8080/iflytek/log-web/upload/imgUpload", map, fileMap, new OkHttpT.OKCallback() {
        //        OkHttpT.getInstance().upload("http://10.5.130.89:8080/log-web/upload/imgUpload", map, fileMap, new OkHttpT.OKCallback() {
        //            @Override
        //            public void onSuc(String result) {
        //                System.out.println(result);
        //            }
        //
        //            @Override
        //            public void onErr(String err) {
        //                System.out.println(err);
        //            }
        //        });
        //        String post = OkHttpT.getInstance().post("http://127.0.0.1:8080/hi/login", userMap);
        //        post = OkHttpT.getInstance().get("http://www.baidu.com");
        //        post = OkHttpT.getInstance().get("http://127.0.0.1:8080/hi/register");
        //        String post = OkHttpT.getInstance().post("http://47.97.171.45:8022/SpringBootAPI/app/app/getVersion", map);
        //        System.out.println(post);

        //        map.clear();
        //        map.put("code", "571");
        //        System.out.println(OkHttpT.getInstance().post("http://10.5.19.25:8022/SpringBootAPI/RechargeActivity/findActivityByCode", map));


        //        String post = OkHttpT.getInstance().post("http://127.0.0.1:8080/test/postJson", JSON.toJSONString(map));
        //        System.out.println(post);
        //        OkHttpT.getInstance().post("http://127.0.0.1:8080/test/postJson", JSON.toJSONString(map), new OkHttpT.OKCallback() {
        //            @Override
        //            public void onSuc(String result) {
        //                System.out.println("result-->" + result);
        //            }
        //
        //            @Override
        //            public void onErr(String err) {
        //                System.out.println("err-->" + err);
        //            }
        //        });


        /***** Retrofit *****/
        //                RetrofitT.getInstance().get("http://127.0.0.1:8080/", "test/register", new RetrofitT.RetrofitCallback() {
        //                RetrofitT.getInstance().get("http://127.0.0.1:8080/test/register", new RetrofitT.RetrofitCallback() {
        //        RetrofitT.getInstance().get("http://127.0.0.1:8080/test/register", new RetrofitT.RetrofitCallback() {
        //        RetrofitT.getInstance().get("http://127.0.0.1:8080/test/register",userMap, new RetrofitT.RetrofitCallback() {
        //        RetrofitT.getInstance().post("http://127.0.0.1:8080/test/login", userMap, new RetrofitT.RetrofitCallback() {
        //        RetrofitT.getInstance().post("http://127.0.0.1:8080/test/login/", userMap, new RetrofitT.RetrofitCallback() {
        //        RetrofitT.getInstance().postField("http://127.0.0.1:8080/test/login/", userMap, new RetrofitT.RetrofitCallback() {
        //        RetrofitT.getInstance().post("http://127.0.0.1:8080/", "test/postJson", JSON.toJSONString(userMap), new RetrofitT.RetrofitCallback() {
        //        RetrofitT.getInstance().post("http://127.0.0.1:8080//test/postJson/", "", JSON.toJSONString(userMap), new RetrofitT.RetrofitCallback() {
        //        RetrofitT.getInstance().upload("http://127.0.0.1:8080/", "hi/uploadFileBySpringAndFileName","d:/d.txt", new RetrofitT.RetrofitCallback() {
        //        RetrofitT.getInstance().upload("http://127.0.0.1:8080/", "hi/uploadFileBySpringAndFileName","d:/d.txt", new RetrofitT.RetrofitCallback() {
        //        RetrofitT.getInstance().upload("http://127.0.0.1:8080/test/upload", map, fileMap, new RetrofitT.RetrofitCallback() {
        //        RetrofitT.getInstance().upload("http://127.0.0.1:8080/test/upload", map, "d:/d.txt", new RetrofitT.RetrofitCallback() {

        //        List<File> files = new ArrayList<>();
        //        files.add(new File("d/d.txt"));
        //        RetrofitT.getInstance().upload("http://127.0.0.1:8080/test/upload", map, files, new RetrofitT.RetrofitCallback() {
        //        RetrofitT.getInstance().download("http://127.0.0.1:8080/", "test/download", new RetrofitT.RetrofitCallback() {
        //                    @Override
        //                    public void onSuc(String result) {
        //                        System.out.println(result);
        //                    }
        //
        //                    @Override
        //                    public void onErr(String err) {
        //                        System.out.println(err);
        //                    }
        //                });


        /***** 数据库相关 *****/
        //        Map<String, String> sqlUser = new HashMap<>();
        //        sqlUser.put("user_name", "catface");
        //        sqlUser.put("user_phone", "13012892925");
        //        sqlUser.put("user_email", "catface.wyh@gmail.com");
        //        sqlUser.put("user_pwd", "root");
        //        sqlUser.put("pwd_salt", "QWERDF");
        //        sqlUser.put("create_time", "---");
        //        sqlUser.put("modify_time", "===");
        //        sqlUser.put("is_delete", "-1");
        //        OkHttpT.getInstance().post("http://127.0.0.1:8080/test_sql/insertUser", sqlUser);

        //        tryTest();
        //        test2();
        //        getDirectory(new File("d:/a"));
        //        System.out.println(tempFiles.size());
        //        test3();
        //        md5Test();
        //        fileList();

        //        System.out.println(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        //        System.out.println("" + (int) ((3344384 / Float.parseFloat("" + 25123144)) * 100));
        //        System.out.println("" + (int) ((3344384*100 / 25123144)));
        //
        //
        //        String path = "/sdcard/mobileRobot2/apk/1519914274964.apk";
        //        File file = new File(path);
        //        System.out.println(file.getParent());
        //        System.out.println(file.getName());


        //        PointDownloadT.getInstance().start("http://m3.pc6.com/xxj2/beamer.dmg", "e:/temp/", "beamer.dmg", new PointDownloadT.Callback() {
        //            @Override
        //            public void onProgress(long length, long totalLength) {
        //                System.out.println(length*100/totalLength);
        //            }
        //
        //            @Override
        //            public void onErr() {
        //                System.out.println("err-->");
        //            }
        //
        //            @Override
        //            public void onSuc() {
        //                System.out.println("suc");
        //            }
        //        });


        //        iflytekLogName();

        //        readTxt();

        //        regexTest();

        //        singleInstanceTest();

        //        System.out.println(finallyTest());

        //        equalsTest();

        //        picEncrypt();

        //        timeTest();

        //        System.out.println("end");

        //        finallyTest();

        //        str += "--";
        //        System.out.println(str);


    }

    static String str;

    static void timeTest() {
        System.out.println(DateT.netTimeStamp());

        System.out.println(DateT.year(new Date()) + "-" + DateT.month(new Date()) + "-" + DateT.day(new Date()) + "-" + DateT.hour(new Date()) + "-" + DateT.minute(new Date()) + "-" + DateT.second(new Date()) + "-" + DateT.millis(new Date()));
        System.out.println(DateT.format(new Date(), "yyyy/MM/dd HH:mm:ss"));
        System.out.println(DateT.format("" + System.currentTimeMillis(), "yyyy/MM/dd HH:mm:ss"));
        System.out.println(DateT.format(System.currentTimeMillis(), "yyyy/MM/dd HH:mm:ss"));

        System.out.println(DateT.date("20190412063516"));

        System.out.println(DateT.whatDay(new Date()));

        System.out.println(DateT.period(new Date(System.currentTimeMillis() - 5898735L)));
    }

    static void picEncrypt() {
        String path = "D:\\下载\\图片\\ic_launcher.png";
        File file = new File(path);
        file.renameTo(new File(path.substring(0, path.indexOf(".png"))));
    }

    static void equalsTest() {
        String str1 = "str1";
        String str2 = "str1";

        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str1.equals(str2): " + str1.equals(str2));

        Object obj1 = new Object();
        Object obj2 = new Object();

        System.out.println("obj1 == obj2: " + (obj1 == obj2));
    }

    static String finallyTest() {

        System.out.println("start finallyTest()...");

        try {
            System.out.println("start try{...}");

            int i = 1 / 0;

            System.out.println("end try{...}");
        } catch (Exception e) {
            System.out.println("catch exception: " + e.toString());
        } finally {
            System.out.println("start finally{...}");
        }

        System.out.println("end finallyTest()...");

        return "return...";
    }

    static void singleInstanceTest() {
        long l11 = System.currentTimeMillis();
        Normal.getInstance().show();
        long l12 = System.currentTimeMillis();
        Normal.getInstance().show();
        long l13 = System.currentTimeMillis();
        System.out.println((l12 - l11) + " || " + (l13 - l12));


        long l21 = System.currentTimeMillis();
        Normal2.getInstance().show();
        long l22 = System.currentTimeMillis();
        Normal2.getInstance().show();
        long l23 = System.currentTimeMillis();
        System.out.println((l22 - l21) + " || " + (l23 - l22));


        long l31 = System.currentTimeMillis();
        NormalUpgrade.getInstance().show();
        long l32 = System.currentTimeMillis();
        NormalUpgrade.getInstance().show();
        long l33 = System.currentTimeMillis();
        System.out.println((l32 - l31) + " || " + (l33 - l32));


        long l41 = System.currentTimeMillis();
        Simple.getHelper().show();
        long l42 = System.currentTimeMillis();
        Simple.getHelper().show();
        long l43 = System.currentTimeMillis();
        System.out.println((l42 - l41) + " || " + (l43 - l42));
    }


    static void regexTest() {
        System.out.println(RegexT.getInstance().contains("sdf", "d "));
        RegexT.getInstance().ip();

        String s = "111.5.11.23";
        boolean matches = Pattern.matches(RegexT.IP, s);
        System.out.println(matches);
        System.out.println(RegexT.iz(s, RegexT.IP));
    }

    static void readTxt() {
        File file = new File("../", "util/newLogin.txt");
        System.out.println(file.getAbsolutePath());

        System.out.println(file.exists());


    }

    static void iflytekLogName() {
        String fileName = "crash_readable_1519927939070.txt";
        String dateStr = fileName.substring(fileName.indexOf("crash_readable_") + "crash_readable_".length(), fileName.indexOf(".txt"));
        long fileDT = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss").format(Long.parseLong(dateStr)));
        System.out.println(fileDT);
        System.out.println(fileName);
    }


    static void fileList() {
        String root = "sdcard/a/b/c";
        String url = "http://127.0/aa/rprp.apk";
        String path = root + url.substring(url.lastIndexOf("/" + 1, url.length()));

        File file = new File(path);
        System.out.println(file.getParent());
        System.out.println(file.getName());

        System.out.println(root + " | " + url + " | " + path);


        /*File file= new File("d:/aaa");

        for (File f: file.listFiles()) {
            System.out.println("--->");
            System.out.println(f.getAbsolutePath());
        }*/
    }

    static void md5Test() {
        String s1 = MD5.encryptFile("C:\\Users\\Administrator\\Desktop\\cc_qq.exe");
        System.out.println(s1);
        String s2 = MD5.encryptFile("E:\\temp\\qq.exe");
        System.out.println(s2);
    }

    static void test3() {
        String name = "aewefm_20180225232099_3";
        if (name.contains("_201")) {
            int start = name.indexOf("_201");
            System.out.println(start);
            System.out.println(name.substring(start + 1, start + 15));

        }
    }

    // 递归遍历
    static List<File> tempFiles = new ArrayList<>();

    static void getDirectory(File file) {
        File flist[] = file.listFiles();
        if (flist == null || flist.length == 0) {
            return;
        }
        for (File f : flist) {
            if (f.isDirectory()) {
                //这里将列出所有的文件夹
                System.out.println("Dir==>" + f.getAbsolutePath());
                getDirectory(f);
            } else {
                //这里将列出所有的文件
                System.out.println("file==>" + f.getAbsolutePath());
                tempFiles.add(f);
            }
        }
    }

    static void test2() {
        List<String> list = new ArrayList<>();
        list.add("adsf");
        list.add("adsf2");

        System.out.println(list.toString());
    }

    static String key;

    static void tryTest() {

        String jsonStr = "{\n" +
                "    \"message\": \"操作成功\",\n" +
                "    \"code\": \"0\",\n" +
                "    \"data\": {\n" +
                "        \"activeCount\": \"0\",\n" +
                "        \"userInfo\": {\n" +
                "            \"resacct\": \"xielinxian\",\n" +
                "            \"mainLoginName\": \"7CBC69EA93AC5C2F2B0CD5656E367998\",\n" +
                "            \"userNum\": \"15957524678\",\n" +
                "            \"isSecret\": true,\n" +
                "            \"opCountyCode\": \"5714\",\n" +
                "            \"opId\": \"20039622\",\n" +
                "            \"opRegionCode\": \"571\",\n" +
                "            \"retinfo\": \"操作成功\",\n" +
                "            \"rsp\": \"0\",\n" +
                "            \"orgId\": \"40055307\",\n" +
                "            \"sessId\": \"f95nwl5w5slhxctvp8i2lauqchoq0oht\",\n" +
                "            \"retcode\": \"0\"\n" +
                "        },\n" +
                "        \"rc\": \"0\",\n" +
                "        \"busiInfo\": [\n" +
                "            {\n" +
                "                \"id\": 0,\n" +
                "                \"busiId\": \"8ace47b960e0a1730160f884cd9859f9\",\n" +
                "                \"packageId\": \"8ace47b960e0a1660160f87c0bbb47ff\",\n" +
                "                \"brandCode\": \"1000000000050\",\n" +
                "                \"busiName\": \"开卡\",\n" +
                "                \"busiContent\": \"开卡\",\n" +
                "                \"imgUrl\": \"http://172.31.3.85:9001/image/\\\\1519532180856.png\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 0,\n" +
                "                \"busiId\": \"6ace47b960e0a1730160f884cd9859f9\",\n" +
                "                \"packageId\": \"88ace47b960e0a1730160f884cd98888\",\n" +
                "                \"brandCode\": \"66666668888BBNMMHII\",\n" +
                "                \"busiName\": \"宽带预约\",\n" +
                "                \"busiContent\": \"1.8ace47b960e0a1730160f884cd9859f9\\n2.8ace47b960e0a1730160f884cd9859f9\\n3.8ace47b960e0a1730160f884cd9859f9\\n4.8ace47b960e0a1730160f884cd9859f9\\n5.8ace47b960e0a1730160f884cd9859f9\",\n" +
                "                \"imgUrl\": \"http://172.31.3.85:9001/image/\\\\1519528553155.png\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"cityInfo\": {\n" +
                "            \"regionName\": \"杭州\",\n" +
                "            \"provinceName\": \"浙江\",\n" +
                "            \"countyName\": \"余杭\"\n" +
                "        },\n" +
                "        \"active\": \"0\",\n" +
                "        \"userExt\": {\n" +
                "            \"qrAlipay\": \"1519535945413.jpg\",\n" +
                "            \"qrWx\": \"1519535945426.jpg\",\n" +
                "            \"cardNo\": \"34012319920830111X\",\n" +
                "            \"username\": \"tiger\",\n" +
                "            \"status\": 1,\n" +
                "            \"name\": \"唐婷\",\n" +
                "            \"orgId\": \"acbce67d-ed47-4e28-a561-918bfb9910c5\",\n" +
                "            \"userCards\": [\n" +
                "                \"34012319920830111X\",\n" +
                "                \"123567777777777777\",\n" +
                "                \"321283199310101826\",\n" +
                "                \"321283199310101826\",\n" +
                "                \"321283199310101826\",\n" +
                "                \"340824199109082243\",\n" +
                "                \"34012319920830111X\"\n" +
                "            ]\n" +
                "        },\n" +
                "        \"leftCount\": \"0\"\n" +
                "    },\n" +
                "    \"isLeaf\": true,\n" +
                "    \"isLeaf1\": \"aa\"\n" +
                "}";


        //        String isLeaf1 = filterFieldsJson(jsonStr, InitData.class, "isLeaf1");


        InitData initData = JSON.parseObject(jsonStr, InitData.class);
        System.out.println(initData.getCode());

        System.out.println("开始捕获异常");
        try {
            System.out.println(key.length());
            System.out.println(key.length());
            int i = 9 / 0;
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        System.out.println("异常捕获结束");
    }
}
