package com.thackathon.mim.thk.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMessage is a Querydsl query type for Message
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMessage extends EntityPathBase<Message> {

    private static final long serialVersionUID = -120591150L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMessage message = new QMessage("message");

    public final QPerson addressee;

    public final StringPath content = createString("content");

    public final DatePath<java.time.LocalDate> createdDate = createDate("createdDate", java.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QPerson recipient;

    public QMessage(String variable) {
        this(Message.class, forVariable(variable), INITS);
    }

    public QMessage(Path<? extends Message> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QMessage(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QMessage(PathMetadata metadata, PathInits inits) {
        this(Message.class, metadata, inits);
    }

    public QMessage(Class<? extends Message> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.addressee = inits.isInitialized("addressee") ? new QPerson(forProperty("addressee")) : null;
        this.recipient = inits.isInitialized("recipient") ? new QPerson(forProperty("recipient")) : null;
    }

}

