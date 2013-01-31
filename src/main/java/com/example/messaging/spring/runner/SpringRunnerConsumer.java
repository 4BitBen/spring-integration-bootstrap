package com.example.messaging.spring.runner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Create a consumer to receive events.
 *
 * @author Ben Nelson
 */
public class SpringRunnerConsumer {
    public static void main(String[] args) throws Exception {
        BasicConfigurator.configure(new ConsoleAppender(new PatternLayout("%d> %m%n")));
        org.apache.log4j.Logger.getRootLogger().setLevel(Level.DEBUG);

        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
        ConfigurableEnvironment env = applicationContext.getEnvironment();
        env.setActiveProfiles("Spring-Integration", "Spring-Integration-AMQP", "RabbitMQ");
        applicationContext.load("Consumer.xml");
        applicationContext.refresh();
    }
}
