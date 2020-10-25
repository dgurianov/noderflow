package com.gud.noderflow.persistance;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class EntitySupport {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2" , strategy = "uuid2")
    private String id;

    protected EntitySupport(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
