package com.thackathon.mim.thk.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPersonPostLikes is a Querydsl query type for PersonPostLikes
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPersonPostLikes extends EntityPathBase<PersonPostLikes> {

    private static final long serialVersionUID = -794917646L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPersonPostLikes personPostLikes = new QPersonPostLikes("personPostLikes");

    public final DatePath<java.time.LocalDate> createdDate = createDate("createdDate", java.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QPerson person;

    public final QPost post;

    public QPersonPostLikes(String variable) {
        this(PersonPostLikes.class, forVariable(variable), INITS);
    }

    public QPersonPostLikes(Path<? extends PersonPostLikes> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPersonPostLikes(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPersonPostLikes(PathMetadata metadata, PathInits inits) {
        this(PersonPostLikes.class, metadata, inits);
    }

    public QPersonPostLikes(Class<? extends PersonPostLikes> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.person = inits.isInitialized("person") ? new QPerson(forProperty("person")) : null;
        this.post = inits.isInitialized("post") ? new QPost(forProperty("post"), inits.get("post")) : null;
    }

}

