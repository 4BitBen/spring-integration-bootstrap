package com.example.messaging.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * Adapter from core logic to spring eventing.
 *
 * @author Ben Nelson
 */
public class ApplicationEventPublisherAdapter implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    public ApplicationEventPublisherAdapter() {
        applicationEventPublisher = null;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publish(ApplicationEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}
