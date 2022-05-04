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

    public ToDoListDTO(UUID id, String category, String name, boolean complete) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.complete = complete;
    }
    public ToDoListDTO(){

    }

    private String name;
    private boolean complete;
}
