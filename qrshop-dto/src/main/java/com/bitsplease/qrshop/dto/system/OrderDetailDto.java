package com.bitsplease.qrshop.dto.system;

import com.bitsplease.qrshop.dto.AbstractDto;

/**
 * @author Chrisostomos Bakouras
 */
public class OrderDetailDto extends AbstractDto {

    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
