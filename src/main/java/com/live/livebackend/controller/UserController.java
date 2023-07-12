package com.live.livebackend.controller;

import com.live.livebackend.dto.UserDto;
import com.live.livebackend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(name = "User")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    @Operation(summary = "로그인", description = "API - 로그인.")
    public ResponseEntity<String> login(@RequestBody UserDto userDto, HttpServletResponse response) {
        return userService.login(userDto, response);
    }

    @PostMapping(value = "/signup")
    @Operation(summary = "회원가입", description = "API - 회원가입.")
    public ResponseEntity<String> signup(@RequestBody UserDto userDto) {
        return userService.signup(userDto);
    }

    @PostMapping("/logout")
    @Operation(summary = "로그아웃", description = "API - 로그아웃.")
    public ResponseEntity<String> logout(HttpServletResponse response) {
        return userService.logout(response);
    }
}