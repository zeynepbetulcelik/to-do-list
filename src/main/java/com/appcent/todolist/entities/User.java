package com.appcent.todolist.entities;



import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "users")
@RequiredArgsConstructor
@Getter
@Setter
public class User implements Serializable {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name ="name")
    private String name;

    @Column(name ="surname")
    private String surname;

    @Column(name ="username")
    private String username;

    @Column(name ="password")
    private String password;


    @Column(name ="active")
    private boolean active;

    public User(UUID id) {
        this.id = id;
    }
}
