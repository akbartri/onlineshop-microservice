package com.akbar.onlineshop.auth.service;

import com.akbar.onlineshop.auth.dto.*;
import com.akbar.onlineshop.auth.exception.AppException;
import com.akbar.onlineshop.commons.dto.RegisterDto;
import com.akbar.onlineshop.commons.dto.ResponseDto;
import com.akbar.onlineshop.commons.dto.UserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.nio.CharBuffer;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    @Autowired
    private RestTemplate restTemplate;

    @Value("${jwt.secret}")
    private String secretKey;

    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    @Override
    public ResponseDto register(RegisterDto registerDto) {
        return restTemplate.postForObject("http://user-service/users",registerDto,ResponseDto.class);
    }

    @Override
    public User login(CredentialsDto credentialsDto) {
        var userDto = restTemplate.getForObject("http://user-service/users/login?login="+credentialsDto.getLogin(),UserDto.class);

        if(Objects.isNull(userDto))throw new AppException("User not found!", HttpStatus.NOT_FOUND);
        if(passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), userDto.getPassword()))return userDtoToUser(userDto,createToken(userDto));

        throw new AppException("Invalid password!", HttpStatus.BAD_REQUEST);
    }

    @Override
    public User validateToken(String token) {
        String login = Jwts
                .parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        UserDto userDto = restTemplate.getForObject("http://user-service/users/login?login="+login,UserDto.class);

        if(Objects.isNull(userDto))throw new AppException("User Not Found!", HttpStatus.NOT_FOUND);

        return userDtoToUser(userDto,createToken(userDto));
    }

    private String createToken(UserDto userDto) {
        Claims claims = Jwts.claims().setSubject(userDto.getLogin());
        Date now = new Date();
        Date validity = new Date(now.getTime()+3600000);

        return Jwts
                .builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private static User userDtoToUser(UserDto userDto,String token) {
        User user = new User();
        user.setId(userDto.getUserId());
        user.setLogin(userDto.getLogin());
        user.setToken(token);
        return user;
    }
}
