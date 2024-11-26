package com.example.umc.study.repository.MemberMissionRepository;

import com.example.umc.study.domain.Member;
import com.example.umc.study.domain.Mission;
import com.example.umc.study.domain.enums.MissionStatus;
import com.example.umc.study.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    boolean existsByMissionIdAndStatus(Long missionId, MissionStatus status);

    boolean existsByMemberIdAndMissionIdAndStatus(Long memberId, Long missionId, MissionStatus status);
    Page<MemberMission> findAllByMember(Member member, PageRequest pageRequest);
}
