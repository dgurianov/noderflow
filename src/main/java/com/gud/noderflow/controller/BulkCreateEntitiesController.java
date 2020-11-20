package com.gud.noderflow.controller;

import com.gud.noderflow.config.EndpointURLs;
import com.gud.noderflow.model.attributes.commands.BulkCreateUsersAttributes;
import com.gud.noderflow.service.BulkCreateUserEntitiesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
public class BulkCreateEntitiesController {

    @Autowired
    BulkCreateUserEntitiesService service;

    @RequestMapping(
            value = EndpointURLs.CURRENT_VERSION + EndpointURLs.BULK_CREATE_USERS,
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String bulkCreateUserEntities(@RequestBody @Valid BulkCreateUsersAttributes request){
        service.bulkCreate(request);
        return "{\"new-user-ids\" : \"created\"}";
    }
}
