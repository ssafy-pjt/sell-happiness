package com.sfs.sellhappiness.domain.items.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOptionItem is a Querydsl query type for OptionItem
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOptionItem extends EntityPathBase<OptionItem> {

    private static final long serialVersionUID = 546029902L;

    public static final QOptionItem optionItem = new QOptionItem("optionItem");

    public final NumberPath<Long> Id = createNumber("Id", Long.class);

    public final ListPath<Option, QOption> options = this.<Option, QOption>createList("options", Option.class, QOption.class, PathInits.DIRECT2);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final NumberPath<Integer> stockNumber = createNumber("stockNumber", Integer.class);

    public QOptionItem(String variable) {
        super(OptionItem.class, forVariable(variable));
    }

    public QOptionItem(Path<? extends OptionItem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOptionItem(PathMetadata metadata) {
        super(OptionItem.class, metadata);
    }

}

