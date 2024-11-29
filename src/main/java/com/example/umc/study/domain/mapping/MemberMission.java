package com.example.umc.study.domain.mapping;

import com.example.umc.study.domain.Member;
import com.example.umc.study.domain.Mission;
import com.example.umc.study.domain.common.BaseEntity;
import com.example.umc.study.domain.enums.MissionStatus;
import lombok.*;


import jakarta.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;
}
