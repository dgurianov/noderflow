package com.gud.noderflow.correlationid;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
/*
Class allows to get correlation ID from HTTP header and store it.
 */
@Component
@Slf4j
public class CorrelationIdInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        MDC.put(CorrelationIdConstants.LOG_CORRELATION_ID_NAME,getCorrelationIdFromHeader(request));
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC.remove(CorrelationIdConstants.LOG_CORRELATION_ID_NAME);
    }

    private String getCorrelationIdFromHeader(HttpServletRequest request){
        String flowIdent = request.getHeader(CorrelationIdConstants.CORRELATION_ID_HEADER);
        if(flowIdent == null || flowIdent.equalsIgnoreCase("")){
            flowIdent = getNewCorrelationId();
        }
        return flowIdent;
    }

    private String getNewCorrelationId(){
        return UUID.randomUUID().toString();
    }
}
