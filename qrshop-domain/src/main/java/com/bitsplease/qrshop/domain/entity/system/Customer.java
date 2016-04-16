package com.bitsplease.qrshop.domain.entity.system;

import com.bitsplease.qrshop.domain.entity.BaseEntity;
import com.bitsplease.qrshop.domain.entity.embeddable.Address;
import com.bitsplease.qrshop.domain.entity.embeddable.Name;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Chrisostomos Bakouras
 */
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    @Embedded
    private Name name;

    @Embedded
    private Address shippingAddress;

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
