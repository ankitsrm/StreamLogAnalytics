package org.example.service;


import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

public class ProducerKafkaConfig {

    private String bootStrapAddress;


    private String topicName;
    
    


    public String getBootStrapAddress() {
		return bootStrapAddress;
	}

	public void setBootStrapAddress(String bootStrapAddress) {
		this.bootStrapAddress = bootStrapAddress;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public ProducerFactory<String,String> producerFactory(){
        Map<String, Object> producerConfig = new HashMap<>();
        producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootStrapAddress );
        producerConfig.put(ProducerConfig.CLIENT_ID_CONFIG, "KafkaProducer");
        producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return new DefaultKafkaProducerFactory<>(producerConfig);

    }

    public KafkaTemplate<String, String> getKafkaTemplate() {

        return new KafkaTemplate<>(producerFactory());
    }

    public void sendMessage (String msg){
       this.getKafkaTemplate().send(topicName,msg);
    }



}
