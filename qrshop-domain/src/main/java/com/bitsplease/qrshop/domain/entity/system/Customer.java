package com.bitsplease.qrshop.domain.entity.system;

import com.bitsplease.qrshop.domain.entity.BaseEntity;
import com.bitsplease.qrshop.domain.entity.embeddable.Address;
import com.bitsplease.qrshop.domain.entity.embeddable.Name;

import javax.persistence.*;
import java.util.List;

/**
 * @author Chrisostomos Bakouras
 */
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    @Embedded
    private Name name;

    @Embedded
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<Order> orders;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
