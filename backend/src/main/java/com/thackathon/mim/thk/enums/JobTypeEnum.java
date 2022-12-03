package com.thackathon.mim.thk.enums;

public enum JobTypeEnum {

    FULLTIME("plný pracovný úväzok"),
    PARTTIME("polovičný pracovný úväzok"),
    INTERNSHIP("stáž"),
    SESSIONAL_WORK("brigáda");

    private final String value;

    JobTypeEnum(final String value) {
        this.value = value;
    }

    public String value(){
        return value;
    }
}
