package com.gud.noderflow.core.publish;

import lombok.Data;

@Data
public abstract class NoderflowEvent {
    private PublishSystem system;
    private String payload;
}
