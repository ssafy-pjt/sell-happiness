package com.sfs.sellhappiness.domain.items.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOption is a Querydsl query type for Option
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOption extends EntityPathBase<Option> {

    private static final long serialVersionUID = 1438914459L;

    public static final QOption option = new QOption("option");

    public final NumberPath<Long> Id = createNumber("Id", Long.class);

    public final StringPath option_name = createString("option_name");

    public final NumberPath<Integer> option_type = createNumber("option_type", Integer.class);

    public final StringPath option_value = createString("option_value");

    public QOption(String variable) {
        super(Option.class, forVariable(variable));
    }

    public QOption(Path<? extends Option> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOption(PathMetadata metadata) {
        super(Option.class, metadata);
    }

}

