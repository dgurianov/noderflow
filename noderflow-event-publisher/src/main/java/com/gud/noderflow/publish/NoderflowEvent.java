package com.gud.noderflow.publish;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class NoderflowEvent<T> {
    private PublishSystem system;
    private String topic;
    private T payload;
}
