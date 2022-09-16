package com.akbar.onlineshop.order.service;

import com.akbar.onlineshop.commons.dto.OrderDetailDto;
import com.akbar.onlineshop.order.repository.OrderDetailRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetailDto> getAllOrderDetails() {
        return orderDetailRepository.findAll().stream().map(orderDetail -> {
            OrderDetailDto orderDetailDto = new OrderDetailDto();
            BeanUtils.copyProperties(orderDetail,orderDetailDto);
            return orderDetailDto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<OrderDetailDto> getOrderDetailsByOrderId(String orderId) {
        return orderDetailRepository.findByOrderId(orderId).stream().map(orderDetail -> {
            OrderDetailDto orderDetailDto = new OrderDetailDto();
            orderDetailDto.setId(orderDetail.getId());
            orderDetailDto.setOrderId(orderDetail.getOrderId());
            orderDetailDto.setProductId(orderDetail.getProductId());
            orderDetailDto.setPrice(orderDetail.getPrice());
            orderDetailDto.setQuantity(orderDetail.getQuantity());
            return orderDetailDto;
        }).collect(Collectors.toList());
    }
}
