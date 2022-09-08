package com.akbar.onlineshop.order.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_order")
@Data
public class Order {
    @Id
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "product_id")
    private String productId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "address_id")
    private String addressId;
    private Integer quantity;
    @Column(name = "order_status")
    private String orderStatus;
}
