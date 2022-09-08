package com.akbar.onlineshop.auth.service;

import com.akbar.onlineshop.auth.dto.*;
import com.akbar.onlineshop.commons.dto.RegisterDto;
import com.akbar.onlineshop.commons.dto.ResponseDto;

public interface AuthService {
    ResponseDto register(RegisterDto registerDto);
    User login(CredentialsDto credentialsDto);
    User validateToken(String token);
}
