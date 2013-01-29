package com.example.messaging.spring.event;

import org.springframework.context.ApplicationEvent;

import java.util.Map;

/**
 * Spring application event for the custom event.
 *
 * @author Ben Nelson
 */
public class MyCustomEventApplicationEvent extends ApplicationEvent {
    /**
     * The custom event
     */
    private final Map myCustomEvent;

    /**
     * Create the event
     *
     * @param source the component that published the event
     * @param myCustomEvent the custom event
     */
    public MyCustomEventApplicationEvent(Object source, Map myCustomEvent) {
        super(source);
        this.myCustomEvent = myCustomEvent;
    }

    /**
     * Get the custom event
     *
     * @return the custom event
     */
    public Map getMyCustomEvent() {
        return myCustomEvent;
    }
}
