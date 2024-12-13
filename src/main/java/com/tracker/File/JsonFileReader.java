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
    private String jsonFile;

    public JsonFileReader(String jsonFString){
        this.jsonFile = jsonFString;

    }

    public List<Order> read(){
        URL url = JsonFileReader.class.getResource("/json/"+jsonFile);
        if(url == null){
            System.out.println("bad arg");
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Order[] tmp_orders = objectMapper.readValue(new File(url.getPath()), Order[].class);

            List<Order> orders = new ArrayList<>(Arrays.asList(tmp_orders));
            
    
            return orders;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    
}
