package com.gud.noderflow.core.enricher;

import com.gud.noderflow.persistance.entity.UserPaymentDataEntity;
import com.gud.noderflow.util.fabricator.PaymentDataFabricator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("payment-data-enricher")
public class UserPaymentDataEntityEnricher implements ObjectEnricher<UserPaymentDataEntity> {

    @Autowired
    private PaymentDataFabricator paymentDataFabricator;

    @Override
    public void enrich(UserPaymentDataEntity object) {
        object.setAccountNumber(paymentDataFabricator.getAccountNumber());
        object.setAccountBalance(paymentDataFabricator.getAccountBalance());
        object.setAccountAutoTopUpAmount(paymentDataFabricator.getAccountTopUpAmount());
        object.setAccountAutoTopUpFrequency(paymentDataFabricator.getTopUpFrequency());
        object.setAccountAutoTopUpNextTime(paymentDataFabricator.getNextTimeToTheNextTopUp());
        object.setAccountAutoTopUpTimeUnits("MINUTES");


    }
}
