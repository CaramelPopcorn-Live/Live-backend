package com.live.livebackend.controller;

import com.live.livebackend.dto.ApplicationDto;
import com.live.livebackend.service.ApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "User")
@Slf4j
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping("/application")
    @Operation(summary = "기계인간 신청", description = "API - 기계인간 신청.")
    public ResponseEntity<String> application(@RequestBody ApplicationDto applicationDto, HttpServletRequest request) {
        return applicationService.application(applicationDto, request);
    }
}
