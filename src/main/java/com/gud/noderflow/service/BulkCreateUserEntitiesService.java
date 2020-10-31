package com.gud.noderflow.service;

import com.gud.noderflow.core.BulkOrderTask;
import com.gud.noderflow.core.BulkTaskBin;
import com.gud.noderflow.core.UserEntityBulkOrderTask;
import com.gud.noderflow.core.enricher.UserEntityEnricher;
import com.gud.noderflow.model.commands.BulkCreateUsersAttributes;
import com.gud.noderflow.persistance.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BulkCreateUserEntitiesService {

    @Autowired
    UserEntityRepository repository;

    @Autowired
    BulkTaskBin taskBin;

    @Autowired
    private UserEntityEnricher enricher;

    public void bulkCreate(BulkCreateUsersAttributes request){
            taskBin.newTask(new UserEntityBulkOrderTask(request.getQuantity(),repository,enricher));

    }

//    public UserEntityAttributes getEntityById(String id ){
//        return UserEntityMapper.INSTANCE.toUserEntityAttributes(
//        repository.findById(id).orElse(null)
//        );
//    }
//
//    public List<UserEntityAttributes> getAllEntities(){
//        return UserEntityMapper.INSTANCE.toListUserEntityAttributes(repository.findAll());
//    }
//
//    public String storeEntity(UserEntityAttributes attributes){
//        UserEntity ue = UserEntityMapper.INSTANCE.toUserEntity(attributes);
//        repository.save(ue);
//        return ue.getId();
//    }

//    public List<TemplateAttributes> storeAllEntities(List<TemplateAttributes> body){
//        repository.deleteAll();
//        repository.saveAll(TemplateEntityToAttributesMapper.INSTANCE.toListTemplateEntity(body));
//        return getAllEntities();
//
//    }
 }
