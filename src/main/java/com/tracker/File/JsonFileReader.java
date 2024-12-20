package com.tracker.File;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tracker.Model.Order;

public class JsonFileReader {

    private static JsonFileReader instance = new JsonFileReader();

    private JsonFileReader(){}


    public static JsonFileReader getInstance(){
        return instance;
    }

    public List<Order> read(String jsonFile){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Order[] tmp_objects = objectMapper.readValue(new File("src/main/resources/json/" + jsonFile), Order[].class);

            List<Order> orders = new ArrayList<>(Arrays.asList(tmp_objects));
            
    
            return orders;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    
}
