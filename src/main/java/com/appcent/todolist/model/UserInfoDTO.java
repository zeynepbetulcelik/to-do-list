package com.appcent.todolist.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
@Getter
@RequiredArgsConstructor
public class UserInfoDTO implements Serializable {

    private static final long serialVersionUID = 2636936156391265891L;
    private String username;
    private String password;
    private String name;
    private String surname;

}