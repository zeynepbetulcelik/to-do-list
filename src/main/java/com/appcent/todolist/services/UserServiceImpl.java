package com.appcent.todolist.services;

import com.appcent.todolist.auth.TokenManager;
import com.appcent.todolist.requests.JwtRequestModel;
import com.appcent.todolist.responses.JwtResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final AuthenticationManager authenticationManager;
    private final TokenManager tokenManager;
    @Override
    public JwtResponseModel registerUser(JwtRequestModel jwtRequestModel) throws IOException {
        SecurityContextHolder.getContext().setAuthentication(authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(jwtRequestModel.getUsername(),
                        jwtRequestModel.getPassword())));
        return null;
    }
}
