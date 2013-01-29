package com.example.messaging.spring.amqp;

import com.example.messaging.MapToJsonStringConverter;
import com.example.messaging.spring.event.MyCustomEventApplicationEvent;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;

import java.io.IOException;
import java.util.Map;

/**
 * Message converter to go from a java object to json.
 *
 * @author Ben Nelson
 */
public class MyCustomEventApplicationEventMessageConverter implements MessageConverter {
    private final MessageConverter delegate;
    private final MapToJsonStringConverter converter;

    public MyCustomEventApplicationEventMessageConverter(MessageConverter delegate, MapToJsonStringConverter converter) {
        this.delegate = delegate;
        this.converter = converter;
    }

    @Override
    public Message toMessage(Object o, MessageProperties messageProperties) throws MessageConversionException {
        if(o instanceof MyCustomEventApplicationEvent) {
            try {
                String data = converter.toJsonString(((MyCustomEventApplicationEvent) o).getMyCustomEvent());
                return new Message(data.getBytes("UTF-8"), messageProperties);
            } catch(IOException e) {
                throw new MessageConversionException("Unable to convert message: " + o, e);
            }
        } else {
            return delegate.toMessage(o, messageProperties);
        }
    }

    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        try {
            Map data = converter.toMap(new String(message.getBody(), "UTF-8"));
            return new MyCustomEventApplicationEvent(this, data);
        } catch(IOException e) {
            throw new MessageConversionException("Unable to convert message: " + message, e);
        }
    }
}
