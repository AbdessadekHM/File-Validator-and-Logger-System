package com.tracker.File;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileWriter {

    private static  JsonFileWriter instance;
    
    static {
        instance = new JsonFileWriter();
    }

    public static JsonFileWriter getInstnace(){
        return instance;
    }

    public <T> void write(List<T> list, String jsonFile){

        try {
            File file = new File("src/main/resources/json/" + jsonFile);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, list);
        } catch (StreamWriteException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {

            
            e.printStackTrace();
        }

    }


    
}
