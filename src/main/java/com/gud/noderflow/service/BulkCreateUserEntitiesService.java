package com.gud.noderflow.service;

import com.gud.noderflow.core.BulkTaskBin;
import com.gud.noderflow.core.UserEntityBulkOrderTask;
import com.gud.noderflow.core.enricher.attributes.UserEntityAttributesEnricher;
import com.gud.noderflow.model.attributes.commands.BulkCreateUsersAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BulkCreateUserEntitiesService {

//    @Autowired
//    @Qualifier("cache")
//    NoderflowCache<UserEntityAttributes> repository;

    @Autowired
    private UserEntityService service;

    @Autowired
    BulkTaskBin taskBin;

    @Autowired
    private UserEntityAttributesEnricher enricher;

    public void bulkCreate(BulkCreateUsersAttributes request){
            taskBin.newTask(new UserEntityBulkOrderTask(request.getQuantity(),service,enricher));

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
