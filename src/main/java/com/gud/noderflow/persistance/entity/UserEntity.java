package com.gud.noderflow.persistance.entity;

import com.gud.noderflow.persistance.EntitySupport;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class UserEntity extends EntitySupport {

    @Size(min = 4, message = "Name at least x chars")
    private String firstName;

    @Size(min = 4, message = "Last Name at least x chars")
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    private UserContactsEntity contacts;

    @OneToOne(cascade = CascadeType.ALL)
    private UserPaymentDataEntity paymentData;

}
