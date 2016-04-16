package com.bitsplease.qrshop.domain.entity.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Chrisostomos Bakouras
 */
@Embeddable
public class Name {
    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
