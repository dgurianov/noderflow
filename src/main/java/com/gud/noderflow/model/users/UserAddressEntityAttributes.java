package com.gud.noderflow.model.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserAddressEntityAttributes {
    @JsonProperty("city")
    private String city;

    @JsonProperty("country")
    private String country;

    @JsonProperty("street")
    private String street;

    @JsonProperty("apartment")
    private String apartment;
}
