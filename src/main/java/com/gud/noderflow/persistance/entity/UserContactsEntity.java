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
@Table(name = "USER_CONTACTS")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class UserContactsEntity extends EntitySupport {

    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    private UserAddressEntity address;

}
