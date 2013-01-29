package com.example.messaging;

import java.io.IOException;
import java.util.Map;

/**
 * Map to JSON and vice versa conversion logic
 *
 * @author Ben Nelson
 */
public interface MapToJsonStringConverter {
    /**
     * Convert from a map to a JSON String.
     *
     * @param data the map
     * @return the JSON String
     * @throws IOException if there is a problem converting
     */
    String toJsonString(Map data) throws IOException;

    /**
     * Convert from a JSON String to a map.
     *
     * @param jsonString the JSON String
     * @return the map
     * @throws IOException if there is a problem converting
     */
    Map toMap(String jsonString) throws IOException;
}
