package com.live.livebackend.data.repository;

import com.live.livebackend.data.entity.UserEntity;
import com.live.livebackend.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserDto findByUserId(String userId);
    UserDto findByUserNameAndUserPassword(String userName, String userPassword);
}
