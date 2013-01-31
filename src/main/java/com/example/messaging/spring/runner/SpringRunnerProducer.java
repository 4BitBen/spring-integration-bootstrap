package com.example.messaging.spring.runner;

import com.example.messaging.MyCustomEventPublisher;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Runner which delegates off to Spring
 *
 * @author Ben Nelson
 */
public class SpringRunnerProducer {

    public static void main(String[] args) throws Exception {

        BasicConfigurator.configure(new ConsoleAppender(new PatternLayout("%d> %m%n")));
        org.apache.log4j.Logger.getRootLogger().setLevel(Level.DEBUG);

        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
        ConfigurableEnvironment env = applicationContext.getEnvironment();
        env.setActiveProfiles("Spring-Integration", "Spring-Integration-AMQP", "RabbitMQ");
        applicationContext.load("Producer.xml");
        applicationContext.refresh();
        MyCustomEventPublisher eventPublisher = applicationContext.getBean("myCustomEvent.publisher", MyCustomEventPublisher.class);
        if(args.length == 1) {
            eventPublisher.publishEvents(Integer.parseInt(args[0]));
        } else {
            eventPublisher.publishEvents(1000);
        }
    }
}
