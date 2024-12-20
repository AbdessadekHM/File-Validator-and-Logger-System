package com.tracker.DAO.utils;

import java.sql.*;
import java.util.*;

import com.tracker.DAO.IStore;
import com.tracker.Model.Order;

public class Orders extends ConnectionToDB implements IStore<Order>{
    
    private static Orders instance = new Orders();

    
    public static Orders getInstance(){
        return instance;
    }

    @Override
    public void add(List<Order> list) {
        list.stream().forEach(order -> add(order));
    }

    @Override
    public void add(Order order) {
        String statement = "INSERT INTO Customers(id, data, amount, customer_id, status) VALUES (" + 
            order.getId() + "," + 
            order.getData() + "," + 
            order.getAmount()+","+ 
            order.getCustomer_id()+","+ 
            order.getStatus() + ")";

        try {
            PreparedStatement stmt = conn.prepareStatement(statement);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public List<Order> get() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public void update(Order element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Order delete(Order element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }


    @Override
    public Order get(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }
    
}
