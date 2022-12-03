package com.thackathon.mim.thk.enums;

public enum GenderEnum {

    MALE("muž"),
    FEMALE("žena"),
    OTHER("neuvedené");

    private final String value;

    GenderEnum(final String value) {
        this.value = value;
    }

    public String value(){
        return value;
    }
}
