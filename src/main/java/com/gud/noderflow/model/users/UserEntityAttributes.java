package com.gud.noderflow.model.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gud.noderflow.model.validators.ValidUserEntity;
import lombok.Data;

@ValidUserEntity
@Data
public class UserEntityAttributes {
    @JsonProperty("first-name")
    private String firstName;

    @JsonProperty("last-name")
    private String lastName;

    @JsonProperty("contacts")
    private UserContactsEntityAttributes contacts;

    @JsonProperty("payment-data")
    private UserPaymentDataEntityAttributes paymentData;
}
