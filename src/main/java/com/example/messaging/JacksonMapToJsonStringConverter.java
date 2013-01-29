package com.example.messaging;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Map;

/**
 * Core logic for converting a map to JSON and vice versa
 *
 * @author Ben Nelson
 */
public class JacksonMapToJsonStringConverter implements MapToJsonStringConverter {
    private final ObjectMapper objectMapper;

    public JacksonMapToJsonStringConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public String toJsonString(Map data) throws IOException {
        return objectMapper.writeValueAsString(data);
    }

    @Override
    public Map toMap(String jsonString) throws IOException {
        return objectMapper.readValue(jsonString, Map.class);
    }
}
