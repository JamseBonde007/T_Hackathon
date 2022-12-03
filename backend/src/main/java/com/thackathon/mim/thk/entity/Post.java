package com.thackathon.mim.thk.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "post")
public class Post implements Serializable {

    @Id
    @GeneratedValue
    @Column(unique = true , nullable = false)
    private Long id;

    private String name;

    @Column(length = 4048)
    private String content;

    @Column(length = 1023)
    private String imageUrl;

    private Long likes;

    private LocalDate createdDate;

    private boolean postType; //false -> otazka, true -> post

    private Boolean visibility; // false -> private, true -> public

    @ManyToOne
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    private Person publisher;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private List<Comment> commentList = new ArrayList<>();
}
