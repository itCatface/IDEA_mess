package cc.catface.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /** 中文乱码 */
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");


        /** 输入 */
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        System.out.println("name&password-->" + name + "/" + password);


        /** 输出 */
        /*try {
            resp.getWriter().println("name&password-->" + name + "/" + password);

            if ("admin".equals(name) && "admin".equals(password))
                resp.getWriter().println("<h1>登录成功Login success...</h1>");
            else resp.getWriter().println("<h1>登录失败Login failure...</h1>");

        } catch (IOException e) {
            e.printStackTrace();
        }*/


        /** 页面跳转 */
        try {
            resp.getWriter().println("name&password-->" + name + "/" + password);

            if ("admin".equals(name) && "admin".equals(password))
                req.getRequestDispatcher("login_success.html").forward(req, resp);
            else resp.sendRedirect("login_failure.html");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
