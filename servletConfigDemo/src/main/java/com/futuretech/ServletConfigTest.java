package com.futuretech;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ServletConfigTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        ServletConfig servletConfig = getServletConfig();
        //通过servletconfig对象获取指定名称的初始化参数
        String username = servletConfig.getInitParameter("username");
        out.println(username);
        out.print("<hr>");

        //通过servletconfig对象获取所有初始化参数名
        Enumeration<String> allParameterNames = servletConfig.getInitParameterNames();
        while (allParameterNames.hasMoreElements()) {
            String parameterName = allParameterNames.nextElement();
            String parameterValue = servletConfig.getInitParameter(parameterName);
            out.println(parameterName + ": " + parameterValue);
        }


    }
}
