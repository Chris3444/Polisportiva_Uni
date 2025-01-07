package it.unife.ip.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> void saveToJson(File file, T data) throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, data);
    }
    public static <T> T readFromJson(File file, Class<T> clazz) throws IOException {
        return objectMapper.readValue(file, clazz);
    }
}
