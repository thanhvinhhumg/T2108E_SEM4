package com.example.hellojspserlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "reqRespServlet", value = "/reqRespServlet", initParams = {
        @WebInitParam(name = "name", value = "T2108E"),
        @WebInitParam(name = "school", value = "FPT Aptech")
})
public class RequestResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = getInitParameter("name");
        String school = getInitParameter("school");
        Writer writer = resp.getWriter();
        writer.write("<h1>" + name + "</h1>");
        writer.write("</br>");
        writer.write("<h1>"+ school + "</h1>");
        writer.write("<form action ='/reqRespServlet' method='post'>");
        writer.write("name : <input type='text' name='name' />");
        writer.write("age : <input type='text' name='age' />");
        writer.write("address : <input type='text' name='address' />");
        writer.write("<input type='submit' value='submit' />");
        writer.write("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        int age = Integer.parseInt(req.getParameter("age"));
//        String address = req.getParameter("address");
//        resp.setContentType("text/html");
////        Writer writer = resp.getWriter();
////        writer.write("name: "+name + " ,age :"+age +" ,address : "+address);
////        resp.sendRedirect("hello-servlet");
//        req.setAttribute("name", name);
//        req.setAttribute("age", age);
//        req.setAttribute("address", address);
//        resp.sendRedirect("hello-servlet");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/hello-servlet");
        dispatcher.forward(req, resp);
    }
}
