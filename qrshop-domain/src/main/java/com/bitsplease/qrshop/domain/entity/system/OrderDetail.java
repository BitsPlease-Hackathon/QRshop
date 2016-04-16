package com.bitsplease.qrshop.domain.entity.system;

import com.bitsplease.qrshop.domain.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Chrisostomos Bakouras
 */
@Entity
@Table(name = "order_details")
public class OrderDetail extends BaseEntity {

    @Column(name = "quantity")
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
