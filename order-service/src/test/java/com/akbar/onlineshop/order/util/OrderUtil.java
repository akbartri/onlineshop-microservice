package com.akbar.onlineshop.order.util;

import com.akbar.onlineshop.commons.dto.OrderDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderUtil {
    public static List<OrderDto> dummyOrders() {
        List<OrderDto> orders = new ArrayList<>();
        OrderDto order1 = new OrderDto();
        order1.setId("1");
        order1.setOrderStatus("PENDING");
        order1.setUserId("1");
        orders.add(order1);

        OrderDto order2 = new OrderDto();
        order2.setId("2");
        order2.setOrderStatus("PAID");
        order2.setUserId("1");
        orders.add(order2);

        OrderDto order3= new OrderDto();
        order3.setId("3");
        order3.setOrderStatus("FINISH");
        order3.setUserId("1");
        orders.add(order3);

        return orders;
    }
}
