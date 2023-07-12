package com.live.livebackend.dto;

import com.live.livebackend.data.entity.ApplicationEntity;
import com.live.livebackend.data.entity.RepairEntity;
import com.live.livebackend.data.entity.UserEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Schema(title = "사용자 정보")
public class UserDto {

    @NotBlank
    @Schema(title = "사용자 아이디", example = "TestId")
    private String userId;

    @NotBlank
    @Schema(title = "사용자 이름", example = "언노운")
    private String userName;

    @Schema(title = "사용자 비밀번호", example = "test1234*")
    private String userPassword;

    @Schema(title = "사용자 프로필 사진 주소", example = "...")
    private String imagePath;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .userId(this.getUserId())
                .userName(this.getUserName())
                .userPassword(this.getUserPassword())
                .imagePath(this.getImagePath())
                .build();
    }
}
