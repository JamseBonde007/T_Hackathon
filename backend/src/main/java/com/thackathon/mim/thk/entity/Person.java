package com.thackathon.mim.thk.entity;

import com.thackathon.mim.thk.enums.GenderEnum;
import com.thackathon.mim.thk.enums.PersonTypeEnum;
import com.thackathon.mim.thk.enums.SkillsEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "person")
public class Person implements Serializable {

    @Id
    @GeneratedValue
    @Column(unique = true , nullable = false)
    private Long id;

    private String name;

    private String lastname;

    private String email;

    private String password;

    private String type;

    private String gender;

    @ElementCollection(targetClass = SkillsEnum.class)
    @Enumerated(EnumType.STRING)
    private List<SkillsEnum> skills = new ArrayList<>();

}
