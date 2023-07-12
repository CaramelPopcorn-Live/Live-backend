package com.live.livebackend.service.impl;

import com.live.livebackend.data.entity.ApplicationEntity;
import com.live.livebackend.data.entity.UserEntity;
import com.live.livebackend.data.repository.ApplicationRepository;
import com.live.livebackend.data.repository.UserRepository;
import com.live.livebackend.dto.ApplicationDto;
import com.live.livebackend.dto.UserDto;
import com.live.livebackend.service.ApplicationService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final UserRepository userRepository;
    private final ApplicationRepository applicationRepository;

    @Override
    public ResponseEntity<String> application(ApplicationDto applicationDto, HttpServletRequest request) {
        Cookie[] list = request.getCookies();
        for(Cookie cookie : list) {
            UserDto user = userRepository.findByUserNameAndUserPassword(cookie.getName(), cookie.getValue());
            if(user != null) {
                ApplicationEntity applicationEntity = applicationDto.toEntity();
                applicationRepository.save(applicationEntity);
                UserEntity userEntity = user.toEntity();
                userEntity.setApplicationEntity(applicationEntity);
                userRepository.save(userEntity);
                return ResponseEntity.ok("신청 성공");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("신청 실패");
    }
}
