package com.gud.noderflow.correlationid;

import org.slf4j.MDC;

import java.util.UUID;

public class CorrelationIdGenerator {


    public static String getNewOrExisting(String key){
        String correlationId = MDC.get(key.toString());
        if(correlationId == null || correlationId.equalsIgnoreCase("")){
            correlationId = getNewCorrelationId();
        }
        return correlationId;
    }

    public static String getNew(){
        return getNewCorrelationId();
    }

    private static String getNewCorrelationId(){
        return UUID.randomUUID().toString();
    }

}
