package com.gud.noderflow.publish.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.common.serialization.LongSerializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.Properties;

public class ProducerBuilder {

    public static Producer<Long, String> createProducer() {

        Properties props = new Properties();
        props.put("bootstrap.servers", KafkaConfig.KAFKA_BROKERS);
        props.put("acks", "all");
        props.put("key.serializer", LongSerializer.class.getName());
        props.put("value.serializer", JsonSerializer.class.getName());

        return new KafkaProducer<Long, String>(props);

    }
}
