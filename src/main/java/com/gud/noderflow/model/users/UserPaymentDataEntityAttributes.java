package com.gud.noderflow.model.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserPaymentDataEntityAttributes {
    @JsonProperty("account-number")
    private String accountNumber;

    @JsonProperty("account-balance")
    private double accountBalance;

    @JsonProperty("account-auto-top-up-amount")
    private double accountAutoTopUpAmount;

    @JsonProperty("account-auto-top-up-frequency")
    private int accountAutoTopUpFrequency;

    @JsonProperty("account-auto-top-up-time-units")
    private String accountAutoTopUpTimeUnits;

}
