package com.akbar.onlineshop.auth.dto;

import lombok.Data;

@Data
public class CredentialsDto {
    private String login;
    private char[] password;
}
