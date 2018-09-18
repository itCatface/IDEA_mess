package cc.catface.controller;

import cc.catface.mds.model.User;
import cc.catface.mds.service.IUserService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
@Controller
@RequestMapping(value = "/user", produces = "application/json; charset=utf-8")
public class UserController {

    @Resource
    private IUserService userService;


    @RequestMapping("/hi")
    @ResponseBody
    public String hi() {
        System.out.println("hi");
        JSONObject json = new JSONObject();

        JSONObject userInfo = new JSONObject();
        userInfo.put("rsp", "0");
        userInfo.put("opId", "20180210");
        userInfo.put("orgId", "4007250");

        JSONObject busiInfo1 = new JSONObject();
        busiInfo1.put("id", "0");
        busiInfo1.put("busiId", "taocan0");
        busiInfo1.put("busiName", "套餐0");
        JSONObject busiInfo2 = new JSONObject();
        busiInfo2.put("id", "1");
        busiInfo2.put("busiId", "taocan1");
        busiInfo2.put("busiName", "套餐1");
        JSONArray busiInfo = new JSONArray();
        busiInfo.add(0, busiInfo1);
        busiInfo.add(1, busiInfo2);

        JSONObject infoList = new JSONObject();
        infoList.put("busiInfo", busiInfo);
        infoList.put("userInfo", userInfo);
        infoList.put("username", "username");
        infoList.put("password", "password");

        json.put("data", infoList);
        json.put("code", "0");
        json.put("message", "操作成功");

        return json.toJSONString();
    }


    /** User */
    @RequestMapping("/selectUser")
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        long userId = Long.parseLong(request.getParameter("id"));
        User user = this.userService.selectUser(userId);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(user));
        response.getWriter().close();
    }
}
