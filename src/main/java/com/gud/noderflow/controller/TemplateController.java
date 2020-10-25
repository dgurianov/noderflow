package com.gud.noderflow.controller;

import com.gud.noderflow.config.EndpointURLs;
import com.gud.noderflow.model.TemplateAttributes;
import com.gud.noderflow.service.TemplateEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TemplateController {

    @Autowired
    TemplateEntityService service;

    @RequestMapping(
            value = EndpointURLs.TEST_STRING,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String testString() {
        return "{ \"value\" : \"Test string\"}";
    }


    @RequestMapping(
            value = EndpointURLs.TEMPLATE_ENTITIES,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TemplateAttributes> getTemplateEntities(){
        return service.getAllEntities();
    }

    @RequestMapping(
            value = EndpointURLs.TEMPLATE_ENTITIES,
            method = RequestMethod.GET,
            params = {"id"},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public TemplateAttributes getEntityById(@RequestParam("id") String id){
        return service.getEntityById(id);
    }

    @RequestMapping(
            value = EndpointURLs.TEMPLATE_ENTITIES,
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<TemplateAttributes> postTemplateEntities(@RequestBody List<TemplateAttributes> request){
        return service.storeAllEntities(request);
    }
}
