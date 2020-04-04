package com.futuretech;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/contextparam")
public class ServletContextDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        ServletContext servletContext = getServletContext();
        PrintWriter out = resp.getWriter();

        //获取指定名称参数值
        String mysqlusername = servletContext.getInitParameter("mysqlusername");
        String mysqlpassword = servletContext.getInitParameter("mysqlpassword");
        out.println("mysqlusername:" + mysqlusername + "<br>");
        out.println("mysqlpassword:" + mysqlpassword + "<br>");

        //以枚举形式获取所有初始化参数
        Enumeration<String> enumeration = servletContext.getInitParameterNames();
        while (enumeration.hasMoreElements()) {
            String enumElement = enumeration.nextElement();
            String initValue = servletContext.getInitParameter(enumElement);
            out.print(enumElement + ":" + initValue + "<br>");
        }
    }
}
