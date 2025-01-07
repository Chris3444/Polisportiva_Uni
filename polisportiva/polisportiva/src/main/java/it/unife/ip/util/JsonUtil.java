package it.unife.ip.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> void saveToJson(File file, T data) throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, data);
    }
    public static <T> T readFromJson(File file, Class<T> clazz) throws IOException {
        return objectMapper.readValue(file, clazz);
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
}
