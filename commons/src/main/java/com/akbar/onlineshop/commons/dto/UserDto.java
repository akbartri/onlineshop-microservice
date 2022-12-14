package com.akbar.onlineshop.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
    private String id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
}
