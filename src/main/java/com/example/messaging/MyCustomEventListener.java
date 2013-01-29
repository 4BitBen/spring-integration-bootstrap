package com.example.messaging;

import java.util.Map;

/**
 * Interface for listen custom events.
 *
 * @author Ben Nelson
 */
public interface MyCustomEventListener {
    /**
     * Receive the data.
     *
     * @param customEvent the data
     */
    void receive(Map customEvent);
}
