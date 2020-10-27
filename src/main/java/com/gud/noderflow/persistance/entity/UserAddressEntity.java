package com.gud.noderflow.persistance.entity;

import com.gud.noderflow.persistance.EntitySupport;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ADDRESS")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class UserAddressEntity extends EntitySupport {
    private String city;

    private String country;

    private String street;

    private String apartment;
}
