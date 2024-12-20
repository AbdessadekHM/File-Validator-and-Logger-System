package com.tracker.DAO.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.tracker.DAO.IStore;
import com.tracker.Model.Customer;

public class Customers extends ConnectionToDB implements IStore<Customer>{

    private static Customers instance = new Customers();

    private Customers(){}

    public static Customers getInstance(){
        return instance;
    }

    @Override
    public void add(List<Customer> list) {
        list.stream().forEach(customer -> add(customer));
    }

    @Override
    public void add(Customer customer) {
        String statement = "INSERT INTO Customers(id, nom, email, phone) VALUES (" + 
            customer.getId() + "," + 
            customer.getNom() + "," + 
            customer.getEmail()+","+ 
            customer.getPhone() + ")";

        try {
            PreparedStatement stmt = conn.prepareStatement(statement);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Customer> get() {
        String statement = "SELECT * FROM Customers";
        Statement stmt;
        try {
            stmt = conn.prepareStatement(statement);

            ResultSet rs = stmt.executeQuery(statement);
            

            List<Customer> customers = new ArrayList<>();
            while(rs.next()){
                customers.add(new Customer(rs.getInt("id"),rs.getString("nom"),rs.getString("email"), rs.getString("phone")));
            }
            return customers;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        /*
         * a mocked return 
         * TODO: 
         * implement this method and the rest of methods after finishing schedular task
         */
    }

    @Override
    public Customer get(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public void update(Customer element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Customer delete(Customer element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }



}
