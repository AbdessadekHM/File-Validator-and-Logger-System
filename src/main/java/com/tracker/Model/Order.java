package com.tracker.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Order {
    @Getter
    private int id, amount, customer_id;
    @Getter
    private String data, status;

    public Order(int id, int amount, int customer_id, String data, String status){
        this.id = id;
        this.amount = amount;
        this.data = data;
        this.status = status;
        this.customer_id = customer_id;
    }
    
    
}
