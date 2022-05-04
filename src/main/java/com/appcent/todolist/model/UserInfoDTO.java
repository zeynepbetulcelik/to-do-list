package com.appcent.todolist.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@ApiModel(value = "User dto Api model documentation", description = "Model")
public class UserInfoDTO implements Serializable {

    @ApiModelProperty(value = "Unique id field of user dto object")
    private UUID id;


    private static final long serialVersionUID = 2636936156391265891L;
    @ApiModelProperty(value = "Unique username field of user dto object. It is required for signup and login")
    private String username;
    @ApiModelProperty(value = "Password field of user dto object. It is required for signup and login")
    private String password;
    @ApiModelProperty(value = "Name field of user dto object. It is not required for signup or login")
    private String name;

    @ApiModelProperty(value = "Surname field of user dto object. It is not required for signup or login")
    private String surname;
    public UserInfoDTO(String username, String password, String name, String surname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }



}