package com.example.messaging.spring.runner;

import com.example.messaging.MyCustomEventPublisher;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Runner which delegates off to Spring
 *
 * @author Ben Nelson
 */
public class SpringRunnerProducer {

    public static void main(String[] args) throws Exception {

        BasicConfigurator.configure(new ConsoleAppender(new PatternLayout("%d> %m%n")));
        org.apache.log4j.Logger.getRootLogger().setLevel(Level.DEBUG);

        // NOTE: Spring's XXXAware Interfaces are not being called when using the GenericXmlApplicationContext. Not sure why.
//        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
//        ConfigurableEnvironment env = applicationContext.getEnvironment();
//        env.setActiveProfiles("DataVMStack", "DataVMStack-AMQP", "DataVMStack-RabbitMQ");
//        applicationContext.load("WikiIngest-Publisher.xml");
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Producer.xml");
        MyCustomEventPublisher eventPublisher = applicationContext.getBean("myCustomEvent.publisher", MyCustomEventPublisher.class);
        if(args.length == 1) {
            eventPublisher.publishEvents(Integer.parseInt(args[0]));
        } else {
            eventPublisher.publishEvents(1000);
        }
    }
}
