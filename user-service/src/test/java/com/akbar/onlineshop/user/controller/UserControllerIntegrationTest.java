package com.akbar.onlineshop.user.controller;

import com.akbar.onlineshop.commons.dto.UserDto;
import com.akbar.onlineshop.user.service.UserService;
import com.akbar.onlineshop.user.util.UserUtil;
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
class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void getAllUser() throws Exception {
        List<UserDto> dummys = UserUtil.dummys();
        ObjectWriter ow = new ObjectMapper().writerWithDefaultPrettyPrinter();

        when(userService.getAllUser()).thenReturn(dummys);
        mockMvc.perform(get("/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(ow.writeValueAsString(dummys)));
        verify(userService).getAllUser();
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