package com.thackathon.mim.thk.enums;

public enum SkillsEnum {

    JAVA("Java"),
    ANGULAR("Angular"),
    C("C"),
    REACT("React"),
    POSTGRES("Postgres"),
    DOCKER("Docker"),
    GIT("Git");

    private final String value;

    SkillsEnum(final String value) {
        this.value = value;
    }

    public String value(){
        return value;
    }
}
