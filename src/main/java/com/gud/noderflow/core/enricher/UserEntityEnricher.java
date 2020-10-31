package com.gud.noderflow.core.enricher;

import com.gud.noderflow.persistance.entity.UserContactsEntity;
import com.gud.noderflow.persistance.entity.UserEntity;
import com.gud.noderflow.persistance.entity.UserPaymentDataEntity;
import com.gud.noderflow.util.fabricator.UserDataFabricator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserEntityEnricher implements ObjectEnricher<UserEntity> {
    @Autowired
    UserDataFabricator userDataFabricator;

    @Autowired
    UserEntityContactsEnricher contactsObjectEnricher;

    @Autowired
    UserPaymentDataEntityEnricher paymentDataEntityEnricher;

    @Override
    public void enrich(UserEntity object){
        object.setFirstName(userDataFabricator.getFirstName(false));
        object.setLastName(userDataFabricator.getLastName(false));
        UserContactsEntity contacts = new UserContactsEntity();
        contactsObjectEnricher.enrich(contacts);
        UserPaymentDataEntity paymentData = new UserPaymentDataEntity();
        paymentDataEntityEnricher.enrich(paymentData);
        object.setContacts(contacts);
        object.setPaymentData(paymentData);
    }

}
