package com.example.messaging.spring.event;

import com.example.messaging.MyCustomEventListener;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.util.Map;

/**
 * Adapter from core logic to spring eventing.
 *
 * @author Ben Nelson
 */
public class MyCustomEventApplicationEventPublisher implements MyCustomEventListener, ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    public MyCustomEventApplicationEventPublisher() {
        applicationEventPublisher = null;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void receive(Map myCustomEvent) {
        applicationEventPublisher.publishEvent(new MyCustomEventApplicationEvent(this, myCustomEvent));
    }
}
