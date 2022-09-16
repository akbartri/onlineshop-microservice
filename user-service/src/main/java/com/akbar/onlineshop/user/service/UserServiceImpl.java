package com.akbar.onlineshop.user.service;

import com.akbar.onlineshop.commons.dto.*;
import com.akbar.onlineshop.user.model.User;
import com.akbar.onlineshop.user.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<UserDto> getAllUser() {
        return userRepository.findAll().stream().map(user -> {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setLogin(user.getLogin());
            return userDto;
        }).toList();
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        UserDto userDto = new UserDto();
        userRepository.findById(userId).ifPresent(user -> BeanUtils.copyProperties(user, userDto));

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

    @Override
    public ResponseDto getUserOrder(String userId) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus("1");
        responseDto.setMessage("Failed");

        UserDto userDto = new UserDto();
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            userDto.setId(userOptional.get().getId());
            userDto.setLogin(userOptional.get().getLogin());
            userDto.setFirstName(userOptional.get().getFirstName());
            userDto.setLastName(userOptional.get().getLastName());
            userDto.setEmail(userOptional.get().getEmail());
            userDto.setDepartment(userOptional.get().getDepartment());
        }

        List<OrderDto> orderList = Arrays.asList(restTemplate.getForEntity("http://order-service/orders/user?userId="+userId,OrderDto[].class).getBody());

        if(userDto.getId() != null){
            responseDto.setStatus("0");
            responseDto.setMessage("Success");

            UserOrderDto userOrderDto = new UserOrderDto();
            userOrderDto.setId(userDto.getId());
            userOrderDto.setLogin(userDto.getLogin());
            userOrderDto.setOrders(orderList);
            responseDto.setContents(userOrderDto);
        }

        return responseDto;
    }
}
