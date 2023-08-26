package com.example.hellojspserlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(urlPatterns = {"/hello-servlet","/uploadFile"})
public class AuthenFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        String user = (String)session.getAttribute("user");
        String uri = req.getRequestURI();
        String url = req.getRequestURL().toString();
        if (user == null && !uri.equals("jsp") && !uri.equals("login")){
            resp.sendRedirect("login.jsp");
        } else {
            filterChain.doFilter(req,resp);
        }
    }

    @Override
    public void destroy() {

    }
}
