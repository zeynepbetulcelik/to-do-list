package com.appcent.todolist.services;

import com.appcent.todolist.model.UserInfoDTO;
import com.appcent.todolist.model.JwtResponseModel;


public interface UserService {
    JwtResponseModel registerUser(UserInfoDTO userInfoDTO) ;
    JwtResponseModel login(UserInfoDTO userInfoDTO) throws Exception;

}
