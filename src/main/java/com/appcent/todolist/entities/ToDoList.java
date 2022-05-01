package com.appcent.todolist.entities;


import lombok.Data;
import lombok.RequiredArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "list")
@RequiredArgsConstructor
@Data
public class ToDoList implements Serializable {
    @Id
    @GeneratedValue
    private UUID id;

    public ToDoList(UUID id, String category, String name, boolean complete) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.complete = complete;
    }

    @Column(name = "category")
    private String category;
    @Column(name = "name")
    private String name;
    @Column(name = "complete")
    private boolean complete;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
