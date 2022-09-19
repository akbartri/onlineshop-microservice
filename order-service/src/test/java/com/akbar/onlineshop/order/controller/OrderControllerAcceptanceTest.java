package com.akbar.onlineshop.order.controller;

import com.akbar.onlineshop.order.util.OrderUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerAcceptanceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllOrders() throws Exception {
        ObjectWriter ow = new ObjectMapper().writerWithDefaultPrettyPrinter();

        mockMvc.perform(get("/orders"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(ow.writeValueAsString(OrderUtil.dummyOrders())));
    }

    @Test
    void getOrderByUserId() throws Exception {
        ObjectWriter ow = new ObjectMapper().writerWithDefaultPrettyPrinter();

        mockMvc.perform(get("/orders/user?userId=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(ow.writeValueAsString(OrderUtil.dummyOrders().stream().filter(data -> data.getUserId().equalsIgnoreCase("1")).toList())));
    }
}