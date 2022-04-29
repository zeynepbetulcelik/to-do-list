package com.appcent.todolist.controller;

import com.appcent.todolist.auth.TokenManager;
import com.appcent.todolist.requests.UserInfoDTO;
import com.appcent.todolist.responses.JwtResponseModel;
import com.appcent.todolist.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserInfoDTO request) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(userService.login(request));
    }

    @PostMapping("/signup")
    public ResponseEntity<JwtResponseModel> registerUser(@RequestBody UserInfoDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(request));
    }

}