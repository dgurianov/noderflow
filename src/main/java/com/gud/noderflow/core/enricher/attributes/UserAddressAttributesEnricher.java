package com.gud.noderflow.core.enricher.attributes;

import com.gud.noderflow.core.enricher.ObjectEnricher;
import com.gud.noderflow.fabricator.AddressDataFabricator;
import com.gud.noderflow.model.attributes.users.UserAddressEntityAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("address-attr-enricher")
public class UserAddressAttributesEnricher implements ObjectEnricher<UserAddressEntityAttributes> {

    @Autowired
    private AddressDataFabricator addressDataFabricator;

    @Override
    public void enrich(UserAddressEntityAttributes object) {
        object.setCity(addressDataFabricator.getCity());
        object.setApartment(addressDataFabricator.getApartment());
        object.setCountry(addressDataFabricator.getCountry());
        object.setStreet(addressDataFabricator.getStreet());
    }
}
