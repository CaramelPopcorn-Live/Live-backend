package com.live.livebackend.service;

import com.live.livebackend.dto.RepairDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

public interface RepairService {
    ResponseEntity<String> repair(RepairDto repairDto, HttpServletRequest request);
}
