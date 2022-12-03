package com.thackathon.mim.thk.enums;

public enum PersonTypeEnum {

    EXPERT("Expert"),
    TEACHER("Pedagóg"),
    STUDENT("Študent");

    private final String value;

    PersonTypeEnum(final String value) {
        this.value = value;
    }

    public String value(){
        return value;
    }
}
