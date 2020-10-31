package com.gud.noderflow.controller;

import com.gud.noderflow.exception.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class TemplateErrorController {
    //TODO : rename or remove class
/*
   NOT FOUND cannot be intercepted this way !!!!

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNotFount(Exception e) {
        log.warn("Resource not found: \n {}", e.getMessage());
        return "You`ve entered wrong URL! \nPossible choices are:\n"+EndpointUrlMap.getServedUrls();
    }
 */

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(TemplateException.class)
    public String handleTemplateError(Exception e) {
        log.error("Template error and it should be replaced! \n {}", e.getMessage());
        return "Template error and it should be replaced!" + e.getMessage();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String handleInternalError(Exception e) {
        log.error("Handle internal error here! : \n {}", e.getMessage());
        return "Handle internal error here! : " + e.getMessage();
    }

}
