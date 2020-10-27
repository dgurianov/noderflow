package com.gud.noderflow.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserContactsEntityAttributes {
    @JsonProperty("phone")
    private String phone;

    @JsonProperty("address")
    private UserAddressEntityAttributes paymentData;
}
