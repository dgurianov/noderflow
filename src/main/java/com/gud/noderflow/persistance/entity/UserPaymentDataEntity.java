package com.gud.noderflow.persistance.entity;

import com.gud.noderflow.persistance.EntitySupport;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "USER_PAYMENT_DATA")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class UserPaymentDataEntity extends EntitySupport {

    @Size(min = 12 , max = 12, message = "Account number has to be 12 digits")
    private String accountNumber;

    private BigDecimal accountBalance;

    private BigDecimal accountAutoTopUpAmount;

    private long accountAutoTopUpNextTime;

    private int accountAutoTopUpFrequency;

    private String accountAutoTopUpTimeUnits;

}
