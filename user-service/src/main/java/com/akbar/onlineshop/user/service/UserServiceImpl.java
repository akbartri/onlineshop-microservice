package com.akbar.onlineshop.user.service;

import com.akbar.onlineshop.commons.dto.RegisterDto;
import com.akbar.onlineshop.commons.dto.ResponseDto;
import com.akbar.onlineshop.commons.dto.UserDto;
import com.akbar.onlineshop.user.model.User;
import com.akbar.onlineshop.user.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> getAllUser() {
        return userRepository.findAll().stream().map(user -> {
            UserDto userDto = new UserDto();
            userDto.setUserId(user.getUserId());
            userDto.setLogin(user.getLogin());
            return userDto;
        }).toList();
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        UserDto userDto = new UserDto();
        userRepository.findByUserId(userId).ifPresent(user -> BeanUtils.copyProperties(user, userDto));

        return userDto;
    }

    @Override
    public UserDto getUserByLogin(String login) {
        UserDto userDto = new UserDto();
        userRepository.findByLogin(login).ifPresent(user -> BeanUtils.copyProperties(user, userDto));

        return userDto;
    }

    @Override
    public ResponseDto saveUser(RegisterDto registerDto) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus("1");
        responseDto.setMessage("Failed");

        User user = new User();
        BeanUtils.copyProperties(registerDto,user);
        userRepository.save(user);

        responseDto.setStatus("0");
        responseDto.setMessage("Success");

        return responseDto;
    }
}
