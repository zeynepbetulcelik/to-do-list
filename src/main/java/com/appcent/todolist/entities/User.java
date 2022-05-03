package com.appcent.todolist.entities;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user")
@RequiredArgsConstructor
@Getter
@Setter
public class User implements Serializable {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name")
    private String name;

    public User(UUID id, String name, String surname, String username, String password, boolean active) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.active = active;
    }

    @Column(name = "surname")
    private String surname;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;


    @Column(name = "active")
    private boolean active;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<ToDoList> lecturerDocuments = new ArrayList<>();

    public User(UUID id) {
        this.id = id;
    }
}
