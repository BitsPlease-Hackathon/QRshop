package com.bitsplease.qrshop.domain.entity.system;

import com.bitsplease.qrshop.domain.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Chrisostomos Bakouras
 */
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Column(name = "product_name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "sort_description")
    private String sortDescription;

    @Column(name = "price")
    private Double price;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "image_base_64", length = 1048576)
    private String imageBase64;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

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

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }
}
