package com.gud.noderflow.core.publish.kafka;

import com.gud.noderflow.core.publish.EventPublisher;
import com.gud.noderflow.model.NoderflowEvent;
import com.gud.noderflow.model.transactions.MoneyTransaction;
import com.gud.noderflow.model.transactions.NoderflowTransactions;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component("kafka-publisher")
public class KafkaPublisher implements EventPublisher {

//    private Producer<Long, String> kafkaProducer;

    @Autowired
    private KafkaTemplate<String, MoneyTransaction> kafkaTemplate;

//    @PostConstruct
//    private void createProducer(){
//        this.kafkaProducer = ProducerBuilder.createProducer();
//    }

    @Override
    public void publish( NoderflowEvent event) {
        kafkaTemplate.send(event.getTopic(),(MoneyTransaction)event.getPayload());
    }
}
