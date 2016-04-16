package com.bitsplease.qrshop.dto.system;

import com.bitsplease.qrshop.dto.AbstractDto;
import com.bitsplease.qrshop.dto.Reference;
import com.bitsplease.qrshop.dto.embeddable.AddressDto;
import com.bitsplease.qrshop.dto.embeddable.NameDto;

import java.util.List;

/**
 * @author Chrisostomos Bakouras
 */
public class CustomerDto extends AbstractDto {

    private NameDto name;
    private AddressDto address;
    private List<Reference> orders;

    public NameDto getName() {
        return name;
    }

    public void setName(NameDto name) {
        this.name = name;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public List<Reference> getOrders() {
        return orders;
    }

    public void setOrders(List<Reference> orders) {
        this.orders = orders;
    }
}
