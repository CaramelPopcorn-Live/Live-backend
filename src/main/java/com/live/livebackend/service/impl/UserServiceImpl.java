package com.live.livebackend.service.impl;

import com.live.livebackend.data.repository.UserRepository;
import com.live.livebackend.dto.UserDto;
import com.live.livebackend.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<String> login(UserDto userDto, HttpServletResponse response) {
        UserDto user = userRepository.findByUserId(userDto.getUserId());
        if (user.getUserPassword().equals(userDto.getUserPassword())) {
            Cookie cookie = new Cookie(user.getUserId(), user.getUserPassword());
            cookie.setMaxAge(30*60);
            response.addCookie(cookie);
            return ResponseEntity.ok("로그인 성공");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
        }
    }

    @Override
    public ResponseEntity<String> signup(UserDto userDto) {
        if (userRepository.save(userDto.toEntity()) == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("회원가입 실패");
        } else {
            return ResponseEntity.ok("회원가입 성공");
        }
    }

    @Override
    public ResponseEntity<String> logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("userId", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return ResponseEntity.ok("로그아웃 성공");
    }
}
