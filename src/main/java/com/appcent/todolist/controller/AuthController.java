package com.appcent.todolist.controller;


import com.appcent.todolist.model.UserInfoDTO;
import com.appcent.todolist.model.JwtResponseModel;
import com.appcent.todolist.repositories.UserRepository;
import com.appcent.todolist.services.UserService;
import io.swagger.annotations.Api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(value = "Auth Rest Controller", description = "REST API for User")
@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping(value="/login",consumes= MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody UserInfoDTO request) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(userService.login(request));
    }
    @PostMapping("/signup")
    public ResponseEntity<JwtResponseModel> registerUser(@RequestBody UserInfoDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(request));
    }


}