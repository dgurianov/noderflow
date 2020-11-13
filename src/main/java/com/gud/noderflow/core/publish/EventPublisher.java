package com.gud.noderflow.core.publish;

import com.gud.noderflow.model.NoderflowEvent;

public interface EventPublisher {
    public void publish(NoderflowEvent event);
}
