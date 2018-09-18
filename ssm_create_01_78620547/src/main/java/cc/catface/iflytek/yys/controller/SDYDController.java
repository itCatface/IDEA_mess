package cc.catface.iflytek.yys.controller;

import cc.catface.iflytek.yys.engine.Common;
import cc.catface.util.IO.FileT;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
@RequestMapping(produces = "application/json; charset=utf-8")
@Controller
public class SDYDController {

    @RequestMapping("/app/app/getVersion/")
    @ResponseBody
    public String getVersion() {
        return FileT.read(Common.rootPathSD + "getVersion.txt");
    }

    @RequestMapping("/app/user/no4ALogin/")
    @ResponseBody
    public String no4ALogin() {
        return FileT.read(Common.rootPathSD + "no4ALogin.txt");
    }


    /** 实名认证 */
    private final String default_activate_json_path = Common.rootPathSD + "activate.txt";

    @RequestMapping("/crm/activate/checkCert/")
    @ResponseBody
    public String checkCert() {
        Common.sleep(3000);
        return FileT.read(default_activate_json_path);
    }


    @RequestMapping("/openCard/faceCheck/")
    @ResponseBody
    public String faceCheck() {
        return FileT.read(default_activate_json_path);
    }


    @RequestMapping("/crm/activate/checkPhone")
    @ResponseBody
    public String checkPhone() {
        return FileT.read(default_activate_json_path);
    }


    @RequestMapping("/crm/activate/appendUserInfo")
    @ResponseBody
    public String appendUserInfo() {
        return FileT.read(default_activate_json_path);
    }


    /** 开户 */
    private final String default_open_account_json_path = Common.rootPathSD + "open_account.txt";

    @RequestMapping("/local/data/readMsg")
    @ResponseBody
    public String readMsg() {
        return FileT.read(default_open_account_json_path);
    }

    @RequestMapping("/openCard/idCardCheck")
    @ResponseBody
    public String idCardCheck() {
        return FileT.read(Common.rootPathSD + "idCardCheck.txt");
    }

    @RequestMapping("/openCard/phoneNumList")
    @ResponseBody
    public String phoneNumList() {
        return FileT.read(Common.rootPathSD + "phoneNumList.txt");
    }

    @RequestMapping("/openCard/selectPhoneNum")
    @ResponseBody
    public String selectPhoneNum() {
        return FileT.read(Common.rootPathSD + "selectPhoneNum.txt");
    }

    @RequestMapping("/openCard/panacea")
    @ResponseBody
    public String panacea() {
        return FileT.read(Common.rootPathSD + "panacea.txt");
    }

    @RequestMapping("/openCard/orderHandle")
    @ResponseBody
    public String orderHandle(HttpServletRequest request) {
        return FileT.read(Common.rootPathSD + "orderHandle.txt");
    }

    @RequestMapping("/openCard/orderNotify")
    @ResponseBody
    public String orderNotify() {
        return FileT.read(Common.rootPathSD + "orderNotify.txt");
    }
}
