package com.akbar.onlineshop.order.controller;

import com.akbar.onlineshop.commons.dto.OrderDto;
import com.akbar.onlineshop.order.service.OrderService;
import com.akbar.onlineshop.order.util.OrderUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class OrderControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Test
    void getAllOrders() throws Exception {
        List<OrderDto> dummyData = OrderUtil.dummyOrders();

        ObjectWriter ow = new ObjectMapper().writerWithDefaultPrettyPrinter();

        when(orderService.getAllOrders()).thenReturn(dummyData);
        mockMvc.perform(get("/orders"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(ow.writeValueAsString(dummyData)));
        verify(orderService).getAllOrders();
    }

    @Test
    void getOrderByUserId() throws Exception {
        List<OrderDto> dummyData = OrderUtil.dummyOrders().stream().filter(data -> data.getUserId().equalsIgnoreCase("1")).toList();

        ObjectWriter ow = new ObjectMapper().writerWithDefaultPrettyPrinter();

        when(orderService.getOrderByUserId("1")).thenReturn(dummyData);
        mockMvc.perform(get("/orders/user?userId=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(ow.writeValueAsString(dummyData)));
        verify(orderService).getOrderByUserId("1");
    }
}