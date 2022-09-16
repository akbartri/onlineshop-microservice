package com.akbar.onlineshop.order.service;

import com.akbar.onlineshop.commons.dto.OrderDetailDto;
import com.akbar.onlineshop.commons.dto.OrderDto;
import com.akbar.onlineshop.order.repository.OrderDetailRepository;
import com.akbar.onlineshop.order.repository.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailService orderDetailService;

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream().map(order -> {
            OrderDto orderDto = new OrderDto();
            BeanUtils.copyProperties(order,orderDto);
            return orderDto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getOrderByUserId(String userId) {
        return orderRepository.findByUserId(userId).stream().map(order -> {
            OrderDto orderDto = new OrderDto();
            BeanUtils.copyProperties(order,orderDto);
            orderDto.setOrderDetails(orderDetailService.getOrderDetailsByOrderId(order.getId()));
            return orderDto;
        }).collect(Collectors.toList());
    }
}
