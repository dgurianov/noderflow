package com.gud.noderflow.controller;

import com.gud.noderflow.config.EndpointURLs;
import com.gud.noderflow.model.attributes.users.UserEntityAttributes;
import com.gud.noderflow.service.UserEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class UserEntityController {

    @Autowired
    UserEntityService service;


    @RequestMapping(
            value = EndpointURLs.CURRENT_VERSION + EndpointURLs.USERS,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserEntityAttributes> getTemplateEntities(){
        return service.getAllEntities();
    }

    @RequestMapping(
            value = EndpointURLs.CURRENT_VERSION + EndpointURLs.USERS,
            method = RequestMethod.GET,
            params = {"id"},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserEntityAttributes getEntityById(@RequestParam("id") String id){
        return service.getEntityById(id);
    }

    @RequestMapping(
            value = EndpointURLs.CURRENT_VERSION + EndpointURLs.USERS,
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String postUserEntity(@RequestBody @Valid UserEntityAttributes attributes){
        return "{\"new-user-id\" : \""+service.storeEntity(attributes)+"\"}";
    }
}
