package cc.catface.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
@WebServlet(name = "HiServlet")
public class HiServlet extends HttpServlet {


    /* 初始化操作 */
    @Override
    public void init() throws ServletException {
        System.out.println("服务器启动，进行一些初始化操作...");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* 中文乱码 */
        response.setContentType("text/html;charset=UTF-8");


        try {
            response.getWriter().println("<h1>你好hello servlet...</h1>");
            response.getWriter().println(new Date().toLocaleString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
