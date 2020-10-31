package com.gud.noderflow.core.enricher;

import com.gud.noderflow.persistance.entity.UserAddressEntity;
import com.gud.noderflow.persistance.entity.UserContactsEntity;
import com.gud.noderflow.util.fabricator.UserContactsFabricator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserEntityContactsEnricher implements ObjectEnricher<UserContactsEntity> {

    @Autowired
    UserContactsFabricator contactsDataFabricator;

    @Autowired
    UserAddressEntityEnricher addressObjectEnricher;


    @Override
    public void enrich(UserContactsEntity object) {
        object.setPhone(contactsDataFabricator.getPhone());
        UserAddressEntity address = new UserAddressEntity();
        addressObjectEnricher.enrich(address);
        object.setAddress(address);

    }
}
