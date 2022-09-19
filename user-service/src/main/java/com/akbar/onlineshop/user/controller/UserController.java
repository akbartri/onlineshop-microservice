package com.akbar.onlineshop.user.controller;

import com.akbar.onlineshop.commons.dto.RegisterDto;
import com.akbar.onlineshop.commons.dto.ResponseDto;
import com.akbar.onlineshop.commons.dto.UserDto;
import com.akbar.onlineshop.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getAllUser() {
        List<UserDto> userDtoList = userService.getAllUser();
        HttpStatus status = !Objects.isNull(userDtoList) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(userDtoList, status);
    }

    @GetMapping("/userId")
    public ResponseEntity<?> getUserByUserId(@RequestParam String userId) {
        UserDto userDto = userService.getUserByUserId(userId);
        HttpStatus status = !Objects.isNull(userDto) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(userDto, status);
    }

    @GetMapping("/login")
    public ResponseEntity<?> getUserByLogin(@RequestParam String login) {
        UserDto userDto = userService.getUserByLogin(login);
        HttpStatus status = !Objects.isNull(userDto) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(userDto, status);
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody RegisterDto registerDto) {
        ResponseDto responseDto = userService.saveUser(registerDto);
        HttpStatus status = responseDto.getStatus().equals("0") ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(responseDto,status);
    }

    @GetMapping("/order")
    public ResponseEntity<?> getUserOrder(@RequestParam String userId) {
        ResponseDto responseDto = userService.getUserOrder(userId);
        HttpStatus status = responseDto.getStatus().equals("0") ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(responseDto,status);
    }
}
