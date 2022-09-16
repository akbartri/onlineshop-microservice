package com.akbar.onlineshop.product.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "master_product")
@Data
public class Product {
    @Id
    private String id;
    @Column(name = "product_name")
    private String productName;
    private Integer price;
    private String description;
    private Integer stock;
    private String status;
}
