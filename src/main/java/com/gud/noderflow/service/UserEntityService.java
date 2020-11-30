package com.gud.noderflow.service;

import com.gud.noderflow.cache.NoderflowCache;
import com.gud.noderflow.model.attributes.users.UserEntityAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;

@Service
public class UserEntityService {

    private long counter ;

    @Autowired
    NoderflowCache<UserEntityAttributes> cache;

    @PostConstruct
    private void init(){
        counter = 0;
    }

    public UserEntityAttributes getEntityById(String id) {
        return cache.get(id);
    }

    public List<UserEntityAttributes> getAllEntities() {
        return cache.getAll();
    }

    public String storeEntity(UserEntityAttributes attributes) {
        String uuid = UUID.randomUUID().toString();
        cache.put(String.valueOf(++counter), attributes);
        return uuid;
    }

}
