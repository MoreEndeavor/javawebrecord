package com.futuretech;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Login")
public class ServletCollaborate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("123456".equals(password) && "root".equals(username)) {
            //登录成后，转发到welcome这个servet，使用forward()进行转发，最终呈现给用户的是welcome这个server的resposne，
            //也就是说下面的"login success"字样是没法呈现给用户的
            out.print("login success");
            req.getRequestDispatcher("welcome").forward(req, resp);
        } else {
            //登录失败后，将登录页（index.jsp）包含到当前页面中，方便用户再次登录
            out.println("用户名或密码错误，请重试！");
            req.getRequestDispatcher("index.jsp").include(req, resp);
        }
    }
}
