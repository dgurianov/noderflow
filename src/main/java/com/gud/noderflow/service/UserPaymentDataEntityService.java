package com.gud.noderflow.service;

import com.gud.noderflow.cache.NoderflowCache;
import com.gud.noderflow.model.attributes.users.UserEntityAttributes;
import com.gud.noderflow.model.attributes.users.UserPaymentDataEntityAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserPaymentDataEntityService {

    private long counter;

    @Autowired
    NoderflowCache<UserEntityAttributes> cache;


    public List<UserPaymentDataEntityAttributes> getAllEntities() {
        return cache.getAll().stream().map(v -> v.getPaymentData()).collect(Collectors.toList());
    }


}
