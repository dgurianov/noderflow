package com.gud.noderflow.core.enricher;

import com.gud.noderflow.persistance.entity.UserAddressEntity;
import com.gud.noderflow.util.fabricator.AddressDataFabricator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("address-object-enricher")
public class UserAddressEntityEnricher implements ObjectEnricher<UserAddressEntity> {

    @Autowired
    private AddressDataFabricator addressDataFabricator;

    @Override
    public void enrich(UserAddressEntity object) {
        object.setCity(addressDataFabricator.getCity());
        object.setApartment(addressDataFabricator.getApartment());
        object.setCountry(addressDataFabricator.getCountry());
        object.setStreet(addressDataFabricator.getStreet());
    }
}
