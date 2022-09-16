package com.akbar.onlineshop.commons.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductDto {
    private String id;
    private String productName;
    private Integer price;
    private String description;
    private Integer stock;
    private String status;
}
