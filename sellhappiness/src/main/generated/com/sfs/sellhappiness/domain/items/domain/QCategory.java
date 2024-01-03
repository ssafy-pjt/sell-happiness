package com.sfs.sellhappiness.domain.items.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCategory is a Querydsl query type for Category
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCategory extends EntityPathBase<Category> {

    private static final long serialVersionUID = -53142876L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCategory category = new QCategory("category");

    public final ListPath<Category, QCategory> child = this.<Category, QCategory>createList("child", Category.class, QCategory.class, PathInits.DIRECT2);

    public final NumberPath<Integer> depth = createNumber("depth", Integer.class);

    public final NumberPath<Long> Id = createNumber("Id", Long.class);

    public final ListPath<CategoryItem, QCategoryItem> items = this.<CategoryItem, QCategoryItem>createList("items", CategoryItem.class, QCategoryItem.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final QCategory parentId;

    public QCategory(String variable) {
        this(Category.class, forVariable(variable), INITS);
    }

    public QCategory(Path<? extends Category> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCategory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCategory(PathMetadata metadata, PathInits inits) {
        this(Category.class, metadata, inits);
    }

    public QCategory(Class<? extends Category> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.parentId = inits.isInitialized("parentId") ? new QCategory(forProperty("parentId"), inits.get("parentId")) : null;
    }

}

