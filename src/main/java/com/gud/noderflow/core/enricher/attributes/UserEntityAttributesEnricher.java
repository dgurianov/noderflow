package com.gud.noderflow.core.enricher.attributes;

import com.gud.noderflow.core.enricher.ObjectEnricher;
import com.gud.noderflow.fabricator.UserDataFabricator;
import com.gud.noderflow.model.attributes.users.UserContactsEntityAttributes;
import com.gud.noderflow.model.attributes.users.UserEntityAttributes;
import com.gud.noderflow.model.attributes.users.UserPaymentDataEntityAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("user-attr-enricher")
public class UserEntityAttributesEnricher implements ObjectEnricher<UserEntityAttributes> {

    @Autowired
    private UserPaymentDataAttributesEnricher paymentDataEntityEnricher;

    @Autowired
    private UserDataFabricator userDataFabricator;

    @Autowired
    private UserEntityContactsAttributesEnricher contactsAttributesEnricher;

    @Override
    public void enrich(UserEntityAttributes object) {
        object.setFirstName(userDataFabricator.getFirstName(false));
        object.setLastName(userDataFabricator.getLastName(false));
        UserContactsEntityAttributes contacts = new UserContactsEntityAttributes();
        contactsAttributesEnricher.enrich(contacts);
        UserPaymentDataEntityAttributes paymentData = new UserPaymentDataEntityAttributes();
        paymentDataEntityEnricher.enrich(paymentData);
        object.setContacts(contacts);
        object.setPaymentData(paymentData);
    }
}
