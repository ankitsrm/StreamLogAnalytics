package org.example;

import org.example.service.ProducerKafkaConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        ProducerKafkaConfig pc = context.getBean("producerConfig", ProducerKafkaConfig.class);

        pc.sendMessage("I am learning JAVA CODE PRODUCER");
        System.out.println("message delivered check consumer");

    }
}
