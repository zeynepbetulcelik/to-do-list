package com.appcent.todolist.services;

import com.appcent.todolist.requests.UserInfoDTO;
import com.appcent.todolist.responses.JwtResponseModel;


public interface UserService {
    JwtResponseModel registerUser(UserInfoDTO userInfoDTO) ;
    JwtResponseModel login(UserInfoDTO userInfoDTO) throws Exception;

}
