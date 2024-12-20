package com.example.umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -2146278101L;

    public static final QMember member = new QMember("member1");

    public final com.example.umc.study.domain.common.QBaseEntity _super = new com.example.umc.study.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<com.example.umc.study.domain.enums.Gender> gender = createEnum("gender", com.example.umc.study.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final ListPath<com.example.umc.study.domain.mapping.MemberMission, com.example.umc.study.domain.mapping.QMemberMission> memberMissionList = this.<com.example.umc.study.domain.mapping.MemberMission, com.example.umc.study.domain.mapping.QMemberMission>createList("memberMissionList", com.example.umc.study.domain.mapping.MemberMission.class, com.example.umc.study.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final ListPath<com.example.umc.study.domain.mapping.MemberPrefer, com.example.umc.study.domain.mapping.QMemberPrefer> memberPreferList = this.<com.example.umc.study.domain.mapping.MemberPrefer, com.example.umc.study.domain.mapping.QMemberPrefer>createList("memberPreferList", com.example.umc.study.domain.mapping.MemberPrefer.class, com.example.umc.study.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final StringPath nickname = createString("nickname");

    public final NumberPath<Long> point = createNumber("point", Long.class);

    public final ListPath<Qna, QQna> qnaList = this.<Qna, QQna>createList("qnaList", Qna.class, QQna.class, PathInits.DIRECT2);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<com.example.umc.study.domain.enums.SocialType> socialType = createEnum("socialType", com.example.umc.study.domain.enums.SocialType.class);

    public final EnumPath<com.example.umc.study.domain.enums.MemberStatus> status = createEnum("status", com.example.umc.study.domain.enums.MemberStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

