package com.live.livebackend.controller;

import com.live.livebackend.dto.ApplicationDto;
import com.live.livebackend.dto.RepairDto;
import com.live.livebackend.service.ApplicationService;
import com.live.livebackend.service.RepairService;
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
public class RepairController {

    private final RepairService repairService;

    @PostMapping("/repair")
    @Operation(summary = "수리 신청", description = "API - 수리 신청.")
    public ResponseEntity<String> repair(@RequestBody RepairDto repairDto, HttpServletRequest request) {
        return repairService.repair(repairDto, request);
    }
}
