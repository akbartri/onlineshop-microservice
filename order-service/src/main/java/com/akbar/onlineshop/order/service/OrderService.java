package com.akbar.onlineshop.order.service;

import com.akbar.onlineshop.commons.dto.OrderDto;
import com.akbar.onlineshop.order.model.Order;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAllOrders();
    List<OrderDto> getOrderByUserId(String userId);
}
