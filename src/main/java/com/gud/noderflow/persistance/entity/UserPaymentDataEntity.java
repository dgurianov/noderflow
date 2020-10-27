package com.gud.noderflow.persistance.entity;

import com.gud.noderflow.persistance.EntitySupport;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER_PAYMENT_DATA")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class UserPaymentDataEntity extends EntitySupport {

    private String accountNumber;

    private double accountBalance;

    private double accountAutoTopUpAmount;

    private long accountAutoTopUpNextTime;

    private long accountAutoTopUpFrequency;

    private String accountAutoTopUpTimeUnits;

}
