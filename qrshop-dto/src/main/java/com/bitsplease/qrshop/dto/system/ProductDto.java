package com.bitsplease.qrshop.dto.system;

import com.bitsplease.qrshop.dto.AbstractDto;

/**
 * @author Chrisostomos Bakouras
 */
public class ProductDto extends AbstractDto {

    private String name;
    private String description;
    private String sortDescription;
    private Double price;
    private Double discount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSortDescription() {
        return sortDescription;
    }

    public void setSortDescription(String sortDescription) {
        this.sortDescription = sortDescription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
