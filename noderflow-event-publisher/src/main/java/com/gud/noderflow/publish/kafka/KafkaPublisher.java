package com.gud.noderflow.publish.kafka;

import com.gud.noderflow.publish.EventPublisher;
import com.gud.noderflow.publish.NoderflowEvent;
import com.gud.noderflow.model.attributes.transactions.MoneyTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component("kafka-publisher")
public class KafkaPublisher implements EventPublisher {

    @Autowired
    private KafkaTemplate<String, MoneyTransaction> kafkaTemplate;

    @Override
    public void publish( NoderflowEvent event) {
        kafkaTemplate.send(event.getTopic(),(MoneyTransaction)event.getPayload());
    }
}
