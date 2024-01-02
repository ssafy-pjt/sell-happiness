package com.sfs.sellhappiness.domain.member.domain;

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

    private static final long serialVersionUID = -1308788794L;

    public static final QMember member = new QMember("member1");

    public final ListPath<com.sfs.sellhappiness.domain.cart.domain.Cart, com.sfs.sellhappiness.domain.cart.domain.QCart> carts = this.<com.sfs.sellhappiness.domain.cart.domain.Cart, com.sfs.sellhappiness.domain.cart.domain.QCart>createList("carts", com.sfs.sellhappiness.domain.cart.domain.Cart.class, com.sfs.sellhappiness.domain.cart.domain.QCart.class, PathInits.DIRECT2);

    public final StringPath memberEmail = createString("memberEmail");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

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

