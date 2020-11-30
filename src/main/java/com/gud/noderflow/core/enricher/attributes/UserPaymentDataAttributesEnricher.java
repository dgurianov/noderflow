package com.gud.noderflow.core.enricher.attributes;

import com.gud.noderflow.core.enricher.ObjectEnricher;
import com.gud.noderflow.fabricator.PaymentDataFabricator;
import com.gud.noderflow.model.attributes.users.UserPaymentDataEntityAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("payment-data-attr-enricher")
public class UserPaymentDataAttributesEnricher implements ObjectEnricher<UserPaymentDataEntityAttributes> {

    @Autowired
    private PaymentDataFabricator paymentDataFabricator;

    @Override
    public void enrich(UserPaymentDataEntityAttributes object) {
        object.setAccountNumber(paymentDataFabricator.getAccountNumber());
        object.setAccountBalance(paymentDataFabricator.getAccountBalance());
        object.setAccountAutoTopUpAmount(paymentDataFabricator.getAccountTopUpAmount());
        object.setAccountAutoTopUpFrequency(paymentDataFabricator.getTopUpFrequency());
//        object.setAccountAutoTopUpNextTime(paymentDataFabricator.getNextTimeToTheNextTopUp());
        object.setAccountAutoTopUpTimeUnits("MINUTES");
    }
}
