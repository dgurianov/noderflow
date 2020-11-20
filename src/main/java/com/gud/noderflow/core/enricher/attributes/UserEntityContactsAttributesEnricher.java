package com.gud.noderflow.core.enricher.attributes;

import com.gud.noderflow.core.enricher.ObjectEnricher;
import com.gud.noderflow.fabricator.UserContactsFabricator;
import com.gud.noderflow.model.attributes.users.UserAddressEntityAttributes;
import com.gud.noderflow.model.attributes.users.UserContactsEntityAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserEntityContactsAttributesEnricher implements ObjectEnricher<UserContactsEntityAttributes> {

    @Autowired
    private UserContactsFabricator contactsDataFabricator;

   @Autowired
    private UserAddressAttributesEnricher addressAttributesEnricher;

    @Override
    public void enrich(UserContactsEntityAttributes object) {
        object.setPhone(contactsDataFabricator.getPhone());
        UserAddressEntityAttributes address = new UserAddressEntityAttributes();
        addressAttributesEnricher.enrich(address);
        object.setAddress(address);
    }
}
