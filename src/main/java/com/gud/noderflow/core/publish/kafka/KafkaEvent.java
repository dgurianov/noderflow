package com.gud.noderflow.core.publish.kafka;

import com.gud.noderflow.core.publish.NoderflowEvent;
import com.gud.noderflow.core.publish.PublishSystem;

public class KafkaEvent extends NoderflowEvent {
    private KafkaEvent(){
        this.setSystem(PublishSystem.KAFKA);
    };

    public static Builder builder(){
        return new KafkaEvent().new Builder();
    }

    public class Builder {
        private Builder(){};

        public Builder withPayload(String payload){
            KafkaEvent.this.setPayload(payload);
            return this;
        }

        public KafkaEvent build() { return KafkaEvent.this;}
    }
}
