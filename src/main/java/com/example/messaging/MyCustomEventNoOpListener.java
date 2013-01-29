package com.example.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Map;

/**
 * A MyCustomEventListener that just logs the event it received.
 *
 * @author Ben Nelson
 */
public class MyCustomEventNoOpListener implements MyCustomEventListener {

    private final Logger logger = LoggerFactory.getLogger(MyCustomEventNoOpListener.class);

    @Override
    public void receive(Map myCustomEvent) {
        logger.info(new Date() + ": [x] Received '" + myCustomEvent + "'");
    }
}
