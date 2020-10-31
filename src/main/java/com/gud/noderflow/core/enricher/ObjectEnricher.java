package com.gud.noderflow.core.enricher;

public interface ObjectEnricher<T> {
    public void enrich(T object);
}
