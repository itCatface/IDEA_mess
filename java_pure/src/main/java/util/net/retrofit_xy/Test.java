package util.net.retrofit_xy;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import domain.SignatureVar;
import util.net.LogT;
import util.net.okhttp.imp.OkHttpT;
import util.net.retrofit.imp.RetrofitT;
import util.net.retrofit_xy.domain.ResponseBean;
import util.net.retrofit_xy.domain.WriteSimCard;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class Test {
    public static void main(String[] args) {

        RetrofitT.getInstance().get("http://www.baidu.com", new RetrofitT.RetrofitCallback() {
            @Override public void onSuc(String result) {
                System.out.println(result);
            }

            @Override public void onErr(String err) {
                System.out.println(err);
            }
        });



        /*String s = "080AFFFFFFFFFFFFFFFFFFFF0E0A12170170080004836604";
        byte[] bytes = s.getBytes();
        String s1 = new String(bytes, 28, 20);
        System.out.println(s1);*/
//        s.substring(20, 8)

        /*String s = "{\"code\":200,\"data\":{\"PARAM\":{\"key_info\":\"key_info\",\"region_id\":\"11\",\"login_no\":\"Y10086RBT\",\"group_id\":\"122000141\",\"signFlag\":\"1\",\"picFlag\":\"N\",\"iccidFlag\":\"1\",\"protocolFlag\":\"N\",\"isEflag\":\"N\",\"brand_id\":\"003\",\"brand\":\"神州行\",\"copy_flag\":\"0\",\"cust_name\":\"＊＊佳\",\"id_card\":\"3411**********7019\",\"op_time\":\"20180621104104\",\"org_info\":\"122000141\",\"phone\":\"18855182402\",\"prc_name\":\"4G飞享18元（2018版）\",\"serv_id\":\"11310009679279\",\"verify_mode\":\"\",\"work_name\":\"讯飞\",\"work_no\":\"Y10086RBT\",\"business_seq\":\"O18060900883510\",\"optime_seq\":\"optime_seq\",\"op_code\":\"1104\",\"mbill_seq\":\"\",\"agm_id\":\"11\",\"agm_flag\":\"0\",\"order_id\":\"S18060900940050\",\"sys_accept\":\"30001633891393\",\"busi_detail\":\"业务种类：正常换卡|工单流水：30001633891393|业务名称：正常换卡|活动信息：原卡类型：4GUSIM卡|新SIM卡类型：128K全球通一卡双号OTA卡|详细内容：免费补换卡\"},\"URL\":\"http://120.193.84.12:9900/phoneHandle.go?method=init¶m={0}\"},\"isLeaf\":true,\"message\":\"操作成功\"}";


        SignatureVar signatureVar = new Gson().fromJson(s, SignatureVar.class);
        System.out.println(JSON.toJSON(signatureVar.getData().getPARAM()));*/



        /*try {
            Thread.sleep((new Random().nextInt(5) + 2) * 1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---");*/


        /*Map<String, String> map = new HashMap<>();
        map.put("acctidNo", "");
        map.put("seqNo", "");
        OkHttpT.getInstance().post("http://10.5.133.54:8080/api/transCard/writeSimCard", map, new OkHttpT.OKCallback() {

            @Override
            public void onSuc(String result) {
                domain.WriteSimCard writeSimCard = new Gson().fromJson(result, domain.WriteSimCard.class);
                System.out.println(writeSimCard.getData().getTransCard().getPhone());
            }

            @Override
            public void onErr(String err) {

            }
        });*/


        /*Map<String, String> map = new HashMap<>();
        map.put("test", "msg");
        HttpUtils.getHttpUtils().writeSimCard(map, new ResponseSubscribe<ResponseBean<WriteSimCard>>(new SubscriberListener<ResponseBean<WriteSimCard>>() {

            @Override
            public void onNext(ResponseBean<WriteSimCard> writeSimCardResponseBean) {
                LogT.d("next...");
                LogT.d(writeSimCardResponseBean.getData().toString() + writeSimCardResponseBean.getData());
            }

            @Override
            public void onException(String message) {
                LogT.d("exception:" + message);
            }

            @Override
            public void onComplete() {
                LogT.d("complete...");
            }
        }));*/
    }
}
