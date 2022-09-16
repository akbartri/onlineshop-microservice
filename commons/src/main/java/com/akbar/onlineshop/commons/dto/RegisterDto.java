package com.akbar.onlineshop.commons.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RegisterDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private String password;
    private String login;
}
