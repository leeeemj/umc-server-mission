package com.example.umc.study.repository.MemberRepository;

import com.example.umc.study.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
