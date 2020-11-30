package com.gud.noderflow.model.attributes.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserPaymentDataEntityAttributes {
    @JsonProperty("account-number")
    private String accountNumber;

    @JsonProperty("account-balance")
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal accountBalance;

    @JsonProperty("account-auto-top-up-amount")
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal accountAutoTopUpAmount;

    @JsonProperty("account-auto-top-up-frequency")
    private int accountAutoTopUpFrequency;

    @JsonProperty("account-auto-top-up-time-units")
    private String accountAutoTopUpTimeUnits;

}
