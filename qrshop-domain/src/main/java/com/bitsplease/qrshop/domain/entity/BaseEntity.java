package com.bitsplease.qrshop.domain.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Chrisostomos Bakouras
 */
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(generator = "java-uuid")
    @GenericGenerator(name = "java-uuid", strategy = "com.bitsplease.qrshop.domain.entity.UUIDGenerator")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
