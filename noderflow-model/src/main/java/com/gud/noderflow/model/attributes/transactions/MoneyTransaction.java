package com.gud.noderflow.model.attributes.transactions;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gud.noderflow.model.attributes.users.MoneySerializer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class MoneyTransaction implements NoderflowTransactions{
    private String correlationId;
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal amount;
    private String accountFrom;
    private String accountTo;
}
