package com.akbar.onlineshop.user.controller;

import com.akbar.onlineshop.commons.dto.UserDto;
import com.akbar.onlineshop.user.service.UserService;
import com.akbar.onlineshop.user.util.UserUtil;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserControllerUnitTest {

    @Test
    void getAllUser() {
        List<UserDto> dummys = UserUtil.dummys();
        UserService userService = Mockito.mock(UserService.class);
        when(userService.getAllUser()).thenReturn(dummys);
        UserController userController = new UserController(userService);

        ResponseEntity<?> responseEntity = new ResponseEntity<>(
                dummys,
                HttpStatus.OK
        );

        assertEquals(responseEntity,userController.getAllUser());
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