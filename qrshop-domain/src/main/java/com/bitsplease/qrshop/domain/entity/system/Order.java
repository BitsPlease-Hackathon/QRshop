package com.bitsplease.qrshop.domain.entity.system;

import com.bitsplease.qrshop.domain.entity.BaseEntity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * @author Chrisostomos Bakouras
 */
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @Column(name = "order_date")
    private Date date;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

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

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
