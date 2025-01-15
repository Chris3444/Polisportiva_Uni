package it.unife.ip.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> void saveToJson(File file, T data) throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, data);
    }
    public static <T> ObservableList<T> readFromJson(File file, Class<T> clazz) throws IOException {
        if (file.exists() && file.length() > 0) {
            CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);
            List<T> tempList = objectMapper.readValue(file, listType);
            ObservableList<T> list = FXCollections.observableArrayList(tempList);
            return list;
            
        }
        else {
            return FXCollections.observableArrayList();
        }
    }
    public static <T> void appendToJson(File file, T object, Class<T> clazz) throws IOException {
        List<T> existingData;

        // Check if the file exists and contains valid JSON data
        if (file.exists() && file.length() > 0) {
            try {
                // Read the existing data from the file
                existingData = objectMapper.readValue(file, new TypeReference<List<T>>() {});
            } catch (Exception e) {
                // If parsing fails, initialize an empty list
                existingData = new ArrayList<>();
            }
        } else {
            // If the file does not exist or is empty, start with an empty list
            existingData = new ArrayList<>();
        }

        // Add the new object to the list
        existingData.add(object);

        // Write the updated list back to the file
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, existingData);
    }

     // Save the modified data to the JSON file
     public static <T> void saveToJson(ObservableList<T> object, File file) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Write the updated data to the JSON file
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, object.toArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> boolean deleteFromJson(File file, T object, Class<T> clazz ) throws IOException {
        if (file.exists() && file.length() > 0) {
            // Read the existing data from the JSON file
            CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);
            List<T> tempList = objectMapper.readValue(file, listType);
            // Check if the index is within bounds
            if (tempList.contains(object)) {
                // Remove the object at the specified index
                tempList.remove(object);
                // Write the updated list back to the file
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, tempList);
    
                return true; // Deletion successful
            } else {
                return false; // No object
            }
        } else {
            return false; // File does not exist or is empty
        }
    }
    
}
