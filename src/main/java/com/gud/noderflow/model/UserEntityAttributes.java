package com.gud.noderflow.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

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
