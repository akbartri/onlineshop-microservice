package com.akbar.onlineshop.commons.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class OrderDto {
    private String id;
    private String userId;
    private String orderStatus;
    private List<OrderDetailDto> orderDetails;
}
