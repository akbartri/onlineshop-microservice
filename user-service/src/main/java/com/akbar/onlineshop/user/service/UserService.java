package com.akbar.onlineshop.user.service;

import com.akbar.onlineshop.commons.dto.RegisterDto;
import com.akbar.onlineshop.commons.dto.ResponseDto;
import com.akbar.onlineshop.commons.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUser();
    UserDto getUserByUserId(String userId);
    UserDto getUserByLogin(String login);
    ResponseDto saveUser(RegisterDto registerDto);
}
