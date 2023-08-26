package com.example.hellojspserlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.Writer;

@WebServlet("/readValue")
public class ReadValueSessionCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html");
            Writer writer = resp.getWriter();
            Cookie[] cookies = req.getCookies();
            for(Cookie c : cookies){
                writer.write("cookName: "+c.getName() +", cookeValue: "+c.getValue());
                writer.write("</br>");
            }
            HttpSession session = req.getSession();
            String name = (String)session.getAttribute("name");
            writer.write("<h1>"+name+"</h1>");
        } catch (Exception ex){
            log(ex.getMessage());
        }
    }
}
