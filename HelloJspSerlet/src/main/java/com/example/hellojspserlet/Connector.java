package com.example.hellojspserlet;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    private Connection connection;

    public synchronized Connection getConnection(){
        try {
            //create connection
            if ( connection == null) {
                String url = "jdbc:mysql://localhost:3306/test";
                String user = "root";
                String pass = "12345678";
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, pass);
                System.out.println("create connection success");
            }
        } catch (Exception ex){
            System.out.printf(ex.getMessage());
        }
        return connection;
    }
}
