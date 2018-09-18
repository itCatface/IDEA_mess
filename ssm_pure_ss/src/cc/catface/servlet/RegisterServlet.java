package cc.catface.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /** 获取参数 */
        System.out.println("获取单值参数name:" + req.getParameter("name"));

        String[] hobits = req.getParameterValues("hobits");
        System.out.println("获取具有多值的参数hobits: " + Arrays.asList(hobits));

        System.out.println("通过 getParameterMap 遍历所有的参数： ");
        Map<String, String[]> parameters = req.getParameterMap();

        Set<String> paramNames = parameters.keySet();
        for (String param : paramNames) {
            String[] value = parameters.get(param);
            System.out.println(param + ":" + Arrays.asList(value));
        }


        /** request的常见方法 */
        System.out.println("\r\n浏览器发出请求时的完整URL，包括协议 主机名 端口(如果有): " + req.getRequestURL());
        System.out.println("浏览器发出请求的资源名部分，去掉了协议和主机名: " + req.getRequestURI());
        System.out.println("请求行中的参数部分: " + req.getQueryString());
        System.out.println("浏览器所处于的客户机的IP地址: " + req.getRemoteAddr());
        System.out.println("浏览器所处于的客户机的主机名: " + req.getRemoteHost());
        System.out.println("浏览器所处于的客户机使用的网络端口: " + req.getRemotePort());
        System.out.println("服务器的IP地址: " + req.getLocalAddr());
        System.out.println("服务器的主机名: " + req.getLocalName());
        System.out.println("得到客户机请求方式: " + req.getMethod());


        /** 获取头信息 */
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            String value = req.getHeader(header);
            System.out.printf("%s\t%s%n", header, value);
        }

        try {
            resp.getWriter().println("<h1>Hello Servlet!</h1>");
            resp.getWriter().println(new Date().toLocaleString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
