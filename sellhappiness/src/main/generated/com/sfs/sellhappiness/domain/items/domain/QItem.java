package com.sfs.sellhappiness.domain.items.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QItem is a Querydsl query type for Item
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QItem extends EntityPathBase<Item> {

    private static final long serialVersionUID = -445604935L;

    public static final QItem item = new QItem("item");

    public final ListPath<CategoryItem, QCategoryItem> categoryItems = this.<CategoryItem, QCategoryItem>createList("categoryItems", CategoryItem.class, QCategoryItem.class, PathInits.DIRECT2);

    public final NumberPath<Long> Id = createNumber("Id", Long.class);

    public final StringPath imgUrl = createString("imgUrl");

    public final DateTimePath<java.time.LocalDateTime> item_reg_date = createDateTime("item_reg_date", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> item_upd_date = createDateTime("item_upd_date", java.time.LocalDateTime.class);

    public final StringPath itemDetail = createString("itemDetail");

    public final StringPath itemName = createString("itemName");

    public final StringPath itemSellStatus = createString("itemSellStatus");

    public final ListPath<OptionItem, QOptionItem> optionItems = this.<OptionItem, QOptionItem>createList("optionItems", OptionItem.class, QOptionItem.class, PathInits.DIRECT2);

    public QItem(String variable) {
        super(Item.class, forVariable(variable));
    }

    public QItem(Path<? extends Item> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItem(PathMetadata metadata) {
        super(Item.class, metadata);
    }

}

