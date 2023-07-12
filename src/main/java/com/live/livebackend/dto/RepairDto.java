package com.live.livebackend.dto;

import com.live.livebackend.data.entity.RepairEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(title = "수리 신청 정보")
public class RepairDto {
    @NotBlank
    @Schema(title = "사용자 이름", example = "언노운")
    private String name;

    @NotBlank
    @Schema(title = "사용자 전화번호", example = "010-0000-0000")
    private String phoneNumber;

    @NotBlank
    @Schema(title = "사용자 거주지 주소", example = "...")
    private String homePath;

    @NotBlank
    @Schema(title = "물품명", example = "...")
    private String itemName;

    @NotBlank
    @Schema(title = "기계번호", example = "...")
    private String machineNumber;

    public RepairEntity toEntity() {
        return RepairEntity.builder()
                .name(this.getName())
                .phoneNumber(this.getPhoneNumber())
                .homePath(this.getHomePath())
                .itemName(this.getItemName())
                .machineNumber(this.getMachineNumber())
                .build();
    }
}
