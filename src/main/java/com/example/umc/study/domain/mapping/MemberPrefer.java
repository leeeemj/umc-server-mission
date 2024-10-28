package com.example.umc.study.domain.mapping;

import com.example.umc.study.domain.FoodCategory;
import com.example.umc.study.domain.Member;
import com.example.umc.study.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPrefer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //연관관계 - 단방향
    //member
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    //foodCategory
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="category_id")
    private FoodCategory foodCategory;





}