package com.futuretech;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebEndpoint;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/setHiddenField")
public class HiddenFormField extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String username = req.getParameter("username");

        PrintWriter out = resp.getWriter();
        out.print("<form action='getHiddenField' method='POST'>");
        out.print("<input type='hidden' name='username' value=" +username+ ">");
        out.print("<input type='submit' value='submit'>");
        out.print("</form>");
    }
}
