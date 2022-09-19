package com.akbar.onlineshop.user.controller;

import com.akbar.onlineshop.user.util.UserUtil;
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
class UserControllerAcceptanceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllUser() throws Exception {
        ObjectWriter ow = new ObjectMapper().writerWithDefaultPrettyPrinter();

        mockMvc.perform(get("/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(ow.writeValueAsString(UserUtil.dummys())));
    }

    @Test
    void getUserByUserId() {
    }

    @Test
    void getUserByLogin() {
    }

    @Test
    void saveUser() {
    }

    @Test
    void getUserOrder() {
    }
}