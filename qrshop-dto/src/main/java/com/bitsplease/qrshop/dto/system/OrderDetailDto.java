package com.bitsplease.qrshop.dto.system;

import com.bitsplease.qrshop.dto.AbstractDto;
import com.bitsplease.qrshop.dto.Reference;

/**
 * @author Chrisostomos Bakouras
 */
public class OrderDetailDto extends AbstractDto {

    private Integer quantity;

    private Reference product;

    private Reference order;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Reference getProduct() {
        return product;
    }

    public void setProduct(Reference product) {
        this.product = product;
    }

    public Reference getOrder() {
        return order;
    }

    public void setOrder(Reference order) {
        this.order = order;
    }
}
