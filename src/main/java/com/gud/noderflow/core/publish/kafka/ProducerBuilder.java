package com.gud.noderflow.core.publish.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

public class ProducerBuilder {

    public static Producer<Long, String> createProducer() {

        Properties props = new Properties();
        props.put("bootstrap.servers", KafkaConfig.KAFKA_BROKERS);
        props.put("acks", "all");
        props.put("key.serializer", LongSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());

        return new KafkaProducer<Long, String>(props);

    }
}
