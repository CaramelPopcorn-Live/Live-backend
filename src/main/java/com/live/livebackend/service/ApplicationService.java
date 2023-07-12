package com.live.livebackend.service;

import com.live.livebackend.dto.ApplicationDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

public interface ApplicationService {
    ResponseEntity<String> application(ApplicationDto applicationDto, HttpServletRequest request);
}
