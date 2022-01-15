package com.onurkus.fourthhomework.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
@Data
public class User implements BaseEntity{

    @SequenceGenerator(name = "generator", sequenceName = "USER_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(length = 50, name = "NAME")
    private String name;

    @Column(length = 50, name = "LAST_NAME")
    private String lastName;

}
