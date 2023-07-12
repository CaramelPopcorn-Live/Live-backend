package com.live.livebackend.service.impl;

import com.live.livebackend.data.entity.RepairEntity;
import com.live.livebackend.data.entity.UserEntity;
import com.live.livebackend.data.repository.RepairRepository;
import com.live.livebackend.data.repository.UserRepository;
import com.live.livebackend.dto.RepairDto;
import com.live.livebackend.dto.UserDto;
import com.live.livebackend.service.RepairService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RepairServiceImpl implements RepairService {

    private final UserRepository userRepository;
    private final RepairRepository repairRepository;

    @Override
    public ResponseEntity<String> repair(RepairDto repairDto, HttpServletRequest request) {
        Cookie[] list = request.getCookies();
        for(Cookie cookie : list) {
            UserDto user = userRepository.findByUserNameAndUserPassword(cookie.getName(), cookie.getValue());
            if(user != null) {
                UserEntity userEntity = user.toEntity();
                UserEntity savedUserEntity = userRepository.save(userEntity);
                RepairEntity repairEntity = repairDto.toEntity();
                repairEntity.setUserEntity(savedUserEntity);
                repairRepository.save(repairEntity);
                return ResponseEntity.ok("수리 신청 성공");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("수리 신청 실패");
    }
}
