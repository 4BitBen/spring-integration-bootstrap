package com.example.messaging.spring.event;

import com.example.messaging.MyCustomEventListener;

/**
 * Adapter to go from a Spring Event to calling a method
 *
 * @author Ben Nelson
 */
public class MyCustomEventApplicationListenerAdapter implements MyCustomEventApplicationEventListener {
    /**
     * The listener
     */
    private final MyCustomEventListener listener;

    public MyCustomEventApplicationListenerAdapter(MyCustomEventListener listener) {
        this.listener = listener;
    }

    /**
     * Take the spring event and call the method on the listner
     *
     * @param myCustomEventApplicationEvent the spring event
     */
    @Override
    public void onApplicationEvent(MyCustomEventApplicationEvent myCustomEventApplicationEvent) {
        listener.receive(myCustomEventApplicationEvent.getMyCustomEvent());
    }
}
