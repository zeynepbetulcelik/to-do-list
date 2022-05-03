package com.appcent.todolist.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class UserInfoDTO implements Serializable {

    private UUID id;
    private static final long serialVersionUID = 2636936156391265891L;
    private String username;
    private String password;
    private String name;

    public UserInfoDTO(String username, String password, String name, String surname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    private String surname;

}