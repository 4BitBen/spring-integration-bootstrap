package com.example.messaging;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Class to publish off the custom events.
 *
 * @author Ben Nelson
 */
public class MyCustomEventPublisher {
    /**
     * The listener to fire the event to
     */
    private final MyCustomEventListener listener;

    /**
     * Create a publisher.
     *
     * @param listener the listener
     */
    public MyCustomEventPublisher(MyCustomEventListener listener) {
        this.listener = listener;
    }

    /**
     * Publish off an event.  An event consists of the following:
     *
     * id: the incremented value
     * UUID: a generated UUID
     * date: the date the event was generated
     * text: some text about the event
     *
     * @param numberOfEvents the number of events to generate
     */
    public void publishEvents(int numberOfEvents) {
        for(int i = 0; i < numberOfEvents; i++) {
            Date eventDate = new Date();
            final String uuid = UUID.randomUUID().toString();

            Map<String, Object> event = new HashMap<String, Object>();
            event.put("id", i);
            event.put("date", eventDate);
            event.put("UUID", uuid);
            event.put("text", "This event was publisehd on " + eventDate + " and generated UUID: " + uuid + " for id: " + i);

            listener.receive(event);
        }
    }
}
