package com.tracker.DAO;

import java.sql.*;

public class DatabaseConnection {

    private String DB_URL = "jdbc:mysql://localhost/store";
    private String USERNAME = "root";
    private String PASWWORD = "abdessadek";
    private Connection conn; 
    private static DatabaseConnection instance;

    private DatabaseConnection(){
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASWWORD);
            System.out.println("connection created");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static DatabaseConnection getInstance(){
        if(instance==null){
            instance = new DatabaseConnection();
        }

        return instance;
    }

    public Connection getConnection(){
        return conn;
    }
    
}
