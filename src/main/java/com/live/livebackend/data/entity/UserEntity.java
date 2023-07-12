package com.live.livebackend.data.entity;

import com.live.livebackend.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class UserEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 8)
    private String userId;

    @Column(nullable = false, length = 8)
    private String userName;

    @Column(nullable = false, length = 16)
    private String userPassword;

    @Column
    private String imagePath;

    @OneToOne
    @JoinColumn(name = "application_id")
    private ApplicationEntity applicationEntity;

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<RepairEntity> repairEntityList = new ArrayList<RepairEntity>();

    public UserDto toDto() {
        return UserDto.builder()
                .userId(this.getUserId())
                .userName(this.getUserName())
                .userPassword(this.getUserPassword())
                .imagePath(this.getImagePath())
                .build();
    }
}
