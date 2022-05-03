package com.appcent.todolist.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class ListResponseModel implements Serializable {
    private UUID id;
    private String category;
    private String name;
    private boolean complete;

    public ListResponseModel(String category, String name, boolean complete,UUID id) {
        this.id=id;
        this.category=category;
        this.name=name;
        this.complete=complete;
    }

    public ListResponseModel() {

    }
}
