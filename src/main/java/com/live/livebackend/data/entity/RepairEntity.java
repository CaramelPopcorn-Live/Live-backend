package com.live.livebackend.data.entity;

import com.live.livebackend.dto.RepairDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="repairs")
public class RepairEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 8)
    private String name;

    @Column(nullable = false, length = 15)
    private String phoneNumber;

    @Column(nullable = false, length = 40)
    private String homePath;

    @Column(length = 20)
    private String itemName;

    @Column(length = 20)
    private String machineNumber;

    @CreatedDate
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public RepairDto toDto() {
        return RepairDto.builder()
                .name(this.getName())
                .phoneNumber(this.getPhoneNumber())
                .homePath(this.getHomePath())
                .itemName(this.getItemName())
                .machineNumber(this.getMachineNumber())
                .build();
    }
}
