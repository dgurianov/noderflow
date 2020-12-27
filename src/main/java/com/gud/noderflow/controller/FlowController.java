package com.gud.noderflow.controller;

import com.gud.noderflow.config.EndpointURLs;
import com.gud.noderflow.service.FlowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FlowController {

    @Autowired
    private FlowService flowService;

    @RequestMapping(method = RequestMethod.GET,
                   value = EndpointURLs.CURRENT_VERSION + EndpointURLs.FLOW + EndpointURLs.START,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public String startFlow(){
        flowService.startService();
        log.info("Start service triggered.");
        return "{\"response\": \"Transaction flow started\"}";
    }

    @RequestMapping(method = RequestMethod.GET,
            value = EndpointURLs.CURRENT_VERSION + EndpointURLs.FLOW + EndpointURLs.STOP,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String stopFlow(){
        flowService.stopService();
        log.info("Stop service triggered.");
        return "{\"response\": \"Transaction flow finished\"}";
    }

}
