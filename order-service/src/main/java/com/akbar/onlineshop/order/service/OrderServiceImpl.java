package com.akbar.onlineshop.order.service;

import com.akbar.onlineshop.commons.dto.OrderDto;
import com.akbar.onlineshop.order.OrderRepository;
import com.akbar.onlineshop.order.model.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream().map(order -> {
            OrderDto orderDto = new OrderDto();
            BeanUtils.copyProperties(order,orderDto);
            return orderDto;
        }).collect(Collectors.toList());
    }
}
