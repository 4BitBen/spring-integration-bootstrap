# Purpose
The purpose of this module is to provide a starting point for utilizing the spring framework for taking your core business logic, which fires an event, and will take that event and publish it off to an enterprise channel - exchange, queue, topic, etc.

For publishing off events, there are a number of abstractions - e.g. JMS, AMQP.  Each provider still has some of its own bootstrap capability - creating a connection, defining the channel, etc.  Spring integration is a nice way of talking to these without polluting your code with vendor or API specifics.

This example uses Spring's XML configuration and takes a particular event, converts it into a JSON object, and the sends it to a RabbitMQ AMQP Exchange.

# Setup
1.  Clone this repository
2.  Build the module
'mvn clean install'
3.  Install [RabbitMQ] (http://www.rabbitmq.com/)
4.  Create a queue called 'springIntegrationExampleQueue' (defined in the Spring XML file)
5.  Run the SpringRunnerProducer as an application in your IDE
6.  Run the SpringRunnerConsumer as an application in your IDE

# TODOs
There are a number of TODO items within the code the help walk you through taking this and hooking in your own event.

# Future Additions
Here are some items that I would like to add on

* Hook into Spring Events without writing some adapter code.  I believe there is a way.  Haven't gotten that to work yet.
* Do not rely on spring-amqp for message conversion.