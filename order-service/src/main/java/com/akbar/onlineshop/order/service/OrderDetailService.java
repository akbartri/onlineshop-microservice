package com.akbar.onlineshop.order.service;

import com.akbar.onlineshop.commons.dto.OrderDetailDto;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetailDto> getAllOrderDetails();
    List<OrderDetailDto> getOrderDetailsByOrderId(String orderId);
}
