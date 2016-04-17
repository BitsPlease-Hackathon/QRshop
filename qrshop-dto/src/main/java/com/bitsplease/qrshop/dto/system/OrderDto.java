package com.bitsplease.qrshop.dto.system;

import com.bitsplease.qrshop.dto.AbstractDto;
import com.bitsplease.qrshop.dto.Reference;

import java.sql.Date;
import java.util.List;

/**
 * @author Chrisostomos Bakouras
 */
public class OrderDto extends AbstractDto {

    private Date date;
    private String status;
    private List<OrderDetailDto> orderDetails;
    private Reference customer;

    public Reference getCustomer() {
        return customer;
    }

    public void setCustomer(Reference customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderDetailDto> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailDto> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
