package com.akbar.onlineshop.commons.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class UserOrderDto {
    private String id;
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private List<OrderDto> orders;
}
