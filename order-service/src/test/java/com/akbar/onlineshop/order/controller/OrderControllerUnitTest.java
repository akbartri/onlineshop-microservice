package com.akbar.onlineshop.order.controller;

import com.akbar.onlineshop.commons.dto.OrderDto;
import com.akbar.onlineshop.order.service.OrderService;
import com.akbar.onlineshop.order.util.OrderUtil;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class OrderControllerUnitTest {

    @Test
    void getAllOrders() throws Exception {
        List<OrderDto> dummyData = OrderUtil.dummyOrders();

        OrderService orderService = Mockito.mock(OrderService.class);
        when(orderService.getAllOrders()).thenReturn(dummyData);
        OrderController orderController = new OrderController(orderService);

        ResponseEntity<?> responseEntity = new ResponseEntity<>(
                dummyData,
                HttpStatus.OK
        );

        assertEquals(responseEntity,orderController.getAllOrders());
    }

    @Test
    void getOrderByUserId() {
        List<OrderDto> dummyData = OrderUtil.dummyOrders().stream().filter(data -> data.getUserId().equalsIgnoreCase("1")).toList();
        OrderService orderService = Mockito.mock(OrderService.class);
        when(orderService.getOrderByUserId("1")).thenReturn(dummyData);
        OrderController orderController = new OrderController(orderService);

        ResponseEntity<?> responseEntity = new ResponseEntity<>(
                dummyData,
                HttpStatus.OK
        );

        assertEquals(responseEntity,orderController.getOrderByUserId("1"));
    }
}