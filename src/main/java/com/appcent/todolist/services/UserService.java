package com.appcent.todolist.services;

import com.appcent.todolist.requests.JwtRequestModel;
import com.appcent.todolist.responses.JwtResponseModel;

import java.io.IOException;

public interface UserService {
    JwtResponseModel registerUser(JwtRequestModel jwtRequestModel) throws IOException;

}
