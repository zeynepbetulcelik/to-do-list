package com.appcent.todolist.controller;

import com.appcent.todolist.entities.User;
import com.appcent.todolist.model.UserInfoDTO;
import com.appcent.todolist.model.JwtResponseModel;
import com.appcent.todolist.repositories.UserRepository;
import com.appcent.todolist.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserInfoDTO request) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(userService.login(request));
    }

    @PostMapping("/signup")
    public ResponseEntity<JwtResponseModel> registerUser(@RequestBody UserInfoDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(request));
    }
    @GetMapping("/users")
    public List<User> Users() {

       User user = userRepository.findByUsername("zeynep@gmail.com").orElse(null);
        List<User>users=new ArrayList<>();
        users.add(user);
        return users;
    }

}