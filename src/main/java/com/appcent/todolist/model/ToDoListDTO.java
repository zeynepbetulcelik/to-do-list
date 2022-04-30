package com.appcent.todolist.model;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;


@Getter
@Setter
public class ToDoListDTO implements Serializable {
    private UUID id;
    private String category;
    private String name;
    private boolean complete;
}
