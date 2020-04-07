package com.futuretech;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/appendtoURL")
public class AppendURL extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        PrintWriter out = resp.getWriter();
        //在引号内给url追加参数，书写要正确
        out.print("<a href='FetchURLParam?username=" + username + "'>visits</a>");
    }
}