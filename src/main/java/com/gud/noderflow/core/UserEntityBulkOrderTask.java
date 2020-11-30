package com.gud.noderflow.core;

import com.gud.noderflow.core.enricher.attributes.UserEntityAttributesEnricher;
import com.gud.noderflow.model.attributes.users.UserEntityAttributes;
import com.gud.noderflow.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserEntityBulkOrderTask implements BulkOrderTask{

    private Long quantity;

    private UserEntityService service;

    @Autowired
    private UserEntityAttributesEnricher enricher;

    public UserEntityBulkOrderTask(Long quantity, UserEntityService service, UserEntityAttributesEnricher enricher){
        this.quantity = quantity;
        this.service = service;
        this.enricher = enricher;
    }

    @Override
    public String call() throws Exception {
        Long counter = this.quantity;
        while(counter > 0 ){
            UserEntityAttributes newUserEntity = UserEntityAttributes.class.newInstance();
            enricher.enrich(newUserEntity);
            counter--;
            service.storeEntity(newUserEntity);
        }
        return "OK";
    }


    @Override
    public String toString() {
        return "UserEntityBulkOrderTask{" +
                "quantity=" + quantity +
                ", enricher=" + enricher +
                '}';
    }
}
