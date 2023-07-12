package com.live.livebackend.service;

import com.live.livebackend.dto.UserDto;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<String> login(UserDto userDto, HttpServletResponse response);
    ResponseEntity<String> signup(UserDto userDto);
    ResponseEntity<String> logout(HttpServletResponse response);
}
