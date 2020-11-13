package com.gud.noderflow.model;

import com.gud.noderflow.core.publish.PublishSystem;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class NoderflowEvent<T> {
    private PublishSystem system;
    private String topic;
    private T payload;
}
