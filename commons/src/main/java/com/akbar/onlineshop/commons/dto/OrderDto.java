package com.akbar.onlineshop.commons.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderDto {
    private String orderId;
    private String productId;
    private String userId;
    private String addressId;
    private Integer quantity;
    private String orderStatus;
}
