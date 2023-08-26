package com.example.hellojspserlet;

import java.io.*;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
//        String name = (String)request.getAttribute("name");
//        int age = (int)request.getAttribute("age");
//        System.out.println(request.getMethod());
//        Enumeration<String> header = request.getHeaderNames();
//        while(header.hasMoreElements()){
//            String key = header.nextElement();
//            String value = request.getHeader(key);
//            System.out.println("key: "+ key + " value: "+value);
//        }

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> abc </h1>");
        out.println("<h1>Test</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/jpg");
        ServletOutputStream servletOutputStream = resp.getOutputStream();
        BufferedInputStream inputStream =
                new BufferedInputStream(new FileInputStream("C:\\Users\\Admin\\Pictures\\test\\anh1.jpg"));
        BufferedOutputStream outputStream = new BufferedOutputStream(servletOutputStream);
        int ch = 0;
        while ((ch= inputStream.read()) != -1){
            outputStream.write(ch);
        }
        outputStream.close();
        inputStream.close();
    }

    public void destroy() {
    }
}