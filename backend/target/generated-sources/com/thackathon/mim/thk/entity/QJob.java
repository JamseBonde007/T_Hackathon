package com.thackathon.mim.thk.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QJob is a Querydsl query type for Job
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QJob extends EntityPathBase<Job> {

    private static final long serialVersionUID = -2091211256L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QJob job = new QJob("job");

    public final QPerson companyContactPerson;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath jobType = createString("jobType");

    public final StringPath name = createString("name");

    public QJob(String variable) {
        this(Job.class, forVariable(variable), INITS);
    }

    public QJob(Path<? extends Job> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QJob(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QJob(PathMetadata metadata, PathInits inits) {
        this(Job.class, metadata, inits);
    }

    public QJob(Class<? extends Job> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.companyContactPerson = inits.isInitialized("companyContactPerson") ? new QPerson(forProperty("companyContactPerson")) : null;
    }

}

