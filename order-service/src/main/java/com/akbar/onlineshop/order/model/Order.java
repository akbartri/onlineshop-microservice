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
    private String id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "order_status")
    private String orderStatus;
}
