package com.akbar.onlineshop.order.controller;

import com.akbar.onlineshop.commons.dto.OrderDto;
import com.akbar.onlineshop.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<?> getAllOrders() {
        List<OrderDto> orderDtoList = orderService.getAllOrders();
        HttpStatus status = !Objects.isNull(orderDtoList) ? HttpStatus.OK : HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(orderDtoList,status);
    }
}
