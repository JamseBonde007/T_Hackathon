package com.thackathon.mim.thk.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue
    @Column(unique = true , nullable = false)
    private Long id;

    private String name;

    private String description;

    private String jobType;

    @ManyToOne
    @JoinColumn(name = "company_contact_person_id", referencedColumnName = "id")
    private Person companyContactPerson;
}
