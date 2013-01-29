package com.example.messaging.spring.event;

import org.springframework.context.ApplicationListener;

/**
 * A Spring ApplicationListener for the event.
 *
 * @author Ben Nelson
 */
public interface MyCustomEventApplicationEventListener extends ApplicationListener<MyCustomEventApplicationEvent> {
}
