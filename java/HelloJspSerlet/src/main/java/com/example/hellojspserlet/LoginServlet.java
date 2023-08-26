package com.example.hellojspserlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final String user = "admin";
    private static final String pass = "admin";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String userName = req.getParameter("name");
            String password = req.getParameter("pass");
            if (userName.equals(user) && password.equals(pass)){
                HttpSession session = req.getSession();
                session.setAttribute("user", userName);
                resp.sendRedirect("/");
            }
        } catch (Exception ex){
            log(ex.getMessage());
        }
    }
}
