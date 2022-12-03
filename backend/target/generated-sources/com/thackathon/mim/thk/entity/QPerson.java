package com.thackathon.mim.thk.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPerson is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPerson extends EntityPathBase<Person> {

    private static final long serialVersionUID = -610768598L;

    public static final QPerson person = new QPerson("person");

    public final StringPath email = createString("email");

    public final StringPath gender = createString("gender");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lastname = createString("lastname");

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final ListPath<com.thackathon.mim.thk.enums.SkillsEnum, EnumPath<com.thackathon.mim.thk.enums.SkillsEnum>> skills = this.<com.thackathon.mim.thk.enums.SkillsEnum, EnumPath<com.thackathon.mim.thk.enums.SkillsEnum>>createList("skills", com.thackathon.mim.thk.enums.SkillsEnum.class, EnumPath.class, PathInits.DIRECT2);

    public final StringPath type = createString("type");

    public QPerson(String variable) {
        super(Person.class, forVariable(variable));
    }

    public QPerson(Path<? extends Person> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPerson(PathMetadata metadata) {
        super(Person.class, metadata);
    }

}

