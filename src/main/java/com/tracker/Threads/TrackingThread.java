package com.tracker.Threads;

import java.util.List;

import com.tracker.DAO.utils.Customers;
import com.tracker.DAO.utils.Orders;
import com.tracker.File.JsonFileReader;
import com.tracker.File.JsonFileWriter;
import com.tracker.Model.Customer;
import com.tracker.Model.Order;

public class TrackingThread extends Thread{

    @Override
    public void run(){
        while (true) {
           try {
            track(); 
            sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }

    }

    public void track(){
        List<Customer> customers = Customers.getInstance().get();

        List<Order> orders = JsonFileReader.getInstance().read("input.json");
        var correctOrders = orders.stream()
                        .filter(order -> customers.stream()
                            .map(customer -> customer.getId())
                            .anyMatch(id -> id == order.getCustomer_id())).toList();
        var inCorrectOrders = orders.stream()
                                .filter(order -> correctOrders.stream().anyMatch(o -> order.getId() != o.getId())).toList();
        
        if(correctOrders.stream().count() > 0){

            //Orders.getInstance().add(correctOrders);
            JsonFileWriter.getInstnace().write(correctOrders, "output.json");
        }else{
            JsonFileWriter.getInstnace().write(inCorrectOrders, "error.json");
        }
        
    }
    
}
