package com.thackathon.mim.thk.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPost is a Querydsl query type for Post
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPost extends EntityPathBase<Post> {

    private static final long serialVersionUID = -402860107L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPost post = new QPost("post");

    public final ListPath<Comment, QComment> commentList = this.<Comment, QComment>createList("commentList", Comment.class, QComment.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    public final DatePath<java.time.LocalDate> createdDate = createDate("createdDate", java.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageUrl = createString("imageUrl");

    public final NumberPath<Long> likes = createNumber("likes", Long.class);

    public final StringPath name = createString("name");

    public final QPerson publisher;

    public final BooleanPath visibility = createBoolean("visibility");

    public QPost(String variable) {
        this(Post.class, forVariable(variable), INITS);
    }

    public QPost(Path<? extends Post> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPost(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPost(PathMetadata metadata, PathInits inits) {
        this(Post.class, metadata, inits);
    }

    public QPost(Class<? extends Post> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.publisher = inits.isInitialized("publisher") ? new QPerson(forProperty("publisher")) : null;
    }

}

