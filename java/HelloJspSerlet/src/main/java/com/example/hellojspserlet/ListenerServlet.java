package com.example.hellojspserlet;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class ListenerServlet implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("sessionId : "+se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
