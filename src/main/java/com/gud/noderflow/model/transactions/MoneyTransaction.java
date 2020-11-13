package com.gud.noderflow.model.transactions;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gud.noderflow.core.publish.PublishSystem;
import com.gud.noderflow.model.users.MoneySerializer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class MoneyTransaction implements NoderflowTransactions{
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal amount;
    private String accountFrom;
    private String accountTo;
}
