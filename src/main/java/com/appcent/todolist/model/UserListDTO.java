package com.appcent.todolist.model;

import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class UserListDTO implements Serializable {

    private String username;
    private List<ToDoListDTO>toDoLists;
}
