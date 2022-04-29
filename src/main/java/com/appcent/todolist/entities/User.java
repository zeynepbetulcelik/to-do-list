package com.appcent.todolist.entities;



import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
