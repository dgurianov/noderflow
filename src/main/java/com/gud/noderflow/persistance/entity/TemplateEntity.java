package com.gud.noderflow.persistance.entity;

import com.gud.noderflow.persistance.EntitySupport;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TEMPLATE_ENTITY")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class TemplateEntity extends EntitySupport {
    //TODO: REmove file

    @Size(min = 4, message = "Name at least x chars")
    private String firstName;

    @Size(min = 4, message = "Second Name at least x chars")
    private String secondName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
