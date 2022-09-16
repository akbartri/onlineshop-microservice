package com.akbar.onlineshop.order.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_order_detail")
@Data
public class OrderDetail {
    @Id
    private String id;
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "product_id")
    private String productId;
    @Column(name = "price")
    private String price;
    private Integer quantity;
}
