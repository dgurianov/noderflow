package com.gud.noderflow.service;

import com.gud.noderflow.core.BulkTaskBin;
import com.gud.noderflow.core.UserEntityBulkOrderTask;
import com.gud.noderflow.core.enricher.attributes.UserEntityAttributesEnricher;
import com.gud.noderflow.model.attributes.commands.BulkCreateUsersAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BulkCreateUserEntitiesService {

    @Autowired
    private UserEntityService service;

    @Autowired
    BulkTaskBin taskBin;

    @Autowired
    private UserEntityAttributesEnricher enricher;

    public void bulkCreate(BulkCreateUsersAttributes request){
            taskBin.newTask(new UserEntityBulkOrderTask(request.getQuantity(),service,enricher));

    }
 }
