package com.tracker.Model;

import lombok.Getter;

public class Customer {
    @Getter
    private int id;
    @Getter
    private String nom, email, phone;

    public Customer(int id, String nom, String email, String phone){
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.phone = phone;
    }
    
}
