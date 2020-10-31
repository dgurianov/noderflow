package com.gud.noderflow.service;

import com.gud.noderflow.mapper.UserEntityMapper;
import com.gud.noderflow.model.users.UserEntityAttributes;
import com.gud.noderflow.persistance.entity.UserEntity;
import com.gud.noderflow.persistance.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEntityService {

    @Autowired
    UserEntityRepository repository;

    public UserEntityAttributes getEntityById(String id ){
        return UserEntityMapper.INSTANCE.toUserEntityAttributes(
        repository.findById(id).orElse(null)
        );
    }

    public List<UserEntityAttributes> getAllEntities(){
        return UserEntityMapper.INSTANCE.toListUserEntityAttributes(repository.findAll());
    }

    public String storeEntity(UserEntityAttributes attributes){
        UserEntity ue = UserEntityMapper.INSTANCE.toUserEntity(attributes);
        repository.save(ue);
        return ue.getId();
    }

 }
