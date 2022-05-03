package com.appcent.todolist.controller;


import com.appcent.todolist.model.UserInfoDTO;
import com.appcent.todolist.services.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "User Rest Controller", description = "REST API for User")
@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;
    @GetMapping("/profile")
    public ResponseEntity<UserInfoDTO> userProfile(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserProfile());

    }
}
