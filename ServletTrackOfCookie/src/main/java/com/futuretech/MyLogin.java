package com.futuretech;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class MyLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        PrintWriter out = resp.getWriter();
        if ("root".equals(username) && "root".equals(password)) {
            Cookie cookie = new Cookie("username", username);
            resp.addCookie(cookie);
            out.print(username + ", Welcome online!" + "<br>");
            req.getRequestDispatcher("link.html").include(req, resp);
        } else {
            out.print("用户名或密码错误，请重试<br>");
            req.getRequestDispatcher("login.html").include(req, resp);
        }

    }
}
