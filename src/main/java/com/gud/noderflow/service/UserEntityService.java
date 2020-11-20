package com.gud.noderflow.service;

import com.gud.noderflow.cache.NoderflowCache;
import com.gud.noderflow.model.attributes.users.UserEntityAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserEntityService {

    @Autowired
    NoderflowCache<UserEntityAttributes> cache;

    public UserEntityAttributes getEntityById(String id) {
        return cache.get(id);
//                UserEntityMapper.INSTANCE.toUserEntityAttributes(
//        repository.findById(id).orElse(null)
//        );
    }

    public List<UserEntityAttributes> getAllEntities() {
        return cache.getAll();
//                UserEntityMapper.INSTANCE.toListUserEntityAttributes(repository.findAll());
    }

    public String storeEntity(UserEntityAttributes attributes) {
//        UserEntity ue = UserEntityMapper.INSTANCE.toUserEntity(attributes);
//        repository.save(ue);
//        return ue.getId();
        String uuid = UUID.randomUUID().toString();
        cache.put(uuid, attributes);
        return uuid;
    }

}
