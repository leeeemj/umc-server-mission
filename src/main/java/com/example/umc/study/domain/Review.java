package com.example.umc.study.domain;

import com.example.umc.study.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String title;

    private Float score;

    //member
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;
    //store
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="store_id")
    private Store store;
}
