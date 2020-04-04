package com.futuretech;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getattr")
public class ServletGetAttribute extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        String requestScope = (String)req.getAttribute("requestScope");
        HttpSession httpSession = req.getSession();
        String sessionScope = (String) httpSession.getAttribute("sessionScope");
        ServletContext application = getServletContext();
        String applicationScope = (String)application.getAttribute("applicationScope");

        PrintWriter out = resp.getWriter();
        out.println("requestScope: " + requestScope + "<br>");
        out.println("sessionScope: " + sessionScope + "<br>");
        out.println("applicationScope: " + applicationScope);
    }
}
