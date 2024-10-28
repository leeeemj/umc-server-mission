package com.example.umc.study.domain;

import com.example.umc.study.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 40)
    private String address;

    private Float score;

    //region
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="region_id")
    private Region region;

    //양방향
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();
}
