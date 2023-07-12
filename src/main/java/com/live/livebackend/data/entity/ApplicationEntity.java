package com.live.livebackend.data.entity;

import com.live.livebackend.dto.ApplicationDto;
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
@Table(name="applications")
public class ApplicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 8)
    private String name;

    @Column(nullable = false, length = 15)
    private String phoneNumber;

    @Column(nullable = false, length = 40)
    private String homePath;

    @CreatedDate
    private LocalDateTime createdAt;


    public ApplicationDto toDto() {
        return ApplicationDto.builder()
                .name(this.getName())
                .phoneNumber(this.getPhoneNumber())
                .homePath(this.getHomePath())
                .build();
    }
}
