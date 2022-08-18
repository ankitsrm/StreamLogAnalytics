package org.example.service;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TopicCreation {

    private String bootStrapAddress;
    private String newTopicName;
    private int numPartitions;
    private short replicationFactor;

    public KafkaAdmin kafkaAdmin(){
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapAddress);
        return new KafkaAdmin(configs);
    }

    public NewTopic getNewTopic(){
        return new NewTopic(newTopicName,numPartitions, replicationFactor);
    }
}
