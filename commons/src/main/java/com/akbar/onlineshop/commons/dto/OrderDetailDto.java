package com.akbar.onlineshop.commons.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderDetailDto {
    private String id;
    private String orderId;
    private String productId;
    private String price;
    private Integer quantity;
}
