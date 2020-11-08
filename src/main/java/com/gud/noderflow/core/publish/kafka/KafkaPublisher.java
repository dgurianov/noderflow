package com.gud.noderflow.core.publish.kafka;

import com.gud.noderflow.core.publish.EventPublisher;
import com.gud.noderflow.core.publish.NoderflowEvent;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("kafka-publisher")
public class KafkaPublisher implements EventPublisher {

    private Producer<Long, String> kafkaProducer;

    @PostConstruct
    private void createProducer(){
        this.kafkaProducer = ProducerBuilder.createProducer();
    }

    @Override
    public void publish( NoderflowEvent event) {
        kafkaProducer.send(
                new ProducerRecord<Long,String>("mytop", "Sample message")
        );


    }
}
