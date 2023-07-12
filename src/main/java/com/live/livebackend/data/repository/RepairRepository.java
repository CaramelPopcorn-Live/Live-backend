package com.live.livebackend.data.repository;

import com.live.livebackend.data.entity.RepairEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairRepository extends JpaRepository<RepairEntity, Long> {
}
