package com.tracker.DAO.utils;

import java.sql.*;

import com.tracker.DAO.DatabaseConnection;

public class ConnectionToDB {
    
   protected static Connection conn = DatabaseConnection.getInstance().getConnection();
}
