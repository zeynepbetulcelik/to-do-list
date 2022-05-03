package com.appcent.todolist.services.impl;

import com.appcent.todolist.auth.TokenManager;
import com.appcent.todolist.entities.User;
import com.appcent.todolist.exception.AlreadyExist;
import com.appcent.todolist.exception.PasswordException;
import com.appcent.todolist.repositories.UserRepository;
import com.appcent.todolist.model.UserInfoDTO;
import com.appcent.todolist.model.JwtResponseModel;
import com.appcent.todolist.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final TokenManager tokenManager;
    private final UserDetailsService userDetailsService;
    private final UserRepository userRepository;

    @Override
    public JwtResponseModel registerUser(UserInfoDTO userInfoDTO)  {
        if (checkUserExists(userInfoDTO.getUsername()))
            throw new AlreadyExist("User already exists with given email");
        if (userInfoDTO.getPassword().isEmpty())
            throw new PasswordException("Please fill the password field");
        User user =new User();
        user.setUsername(userInfoDTO.getUsername());
        user.setPassword(encodePassword(userInfoDTO.getPassword()));
        user.setActive(true);
        user.setName(userInfoDTO.getName());
        user.setSurname(userInfoDTO.getSurname());
        userRepository.save(user);
        UserDetails userDetails=userDetailsService.loadUserByUsername(userInfoDTO.getUsername());
       String jwt= tokenManager.generateJwtToken(userDetails);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userInfoDTO.getUsername(), userInfoDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new JwtResponseModel(jwt);

    }

    @Override
    public JwtResponseModel login(UserInfoDTO userInfoDTO) throws Exception {

        try {
            authenticationManager.authenticate(
                    new
                            UsernamePasswordAuthenticationToken(userInfoDTO.getUsername(),
                            userInfoDTO.getPassword())
            );
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

         UserDetails userDetails = userDetailsService.loadUserByUsername(userInfoDTO.getUsername());
        String jwtToken = tokenManager.generateJwtToken(userDetails);

        return  new JwtResponseModel(jwtToken);
    }

    @Override
    public UserInfoDTO getUserProfile() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user=userRepository.findByUsername(username).orElse(null);
        UserInfoDTO userInfoDTO=new UserInfoDTO();
        userInfoDTO.setName(user.getName());
        userInfoDTO.setSurname(user.getSurname());
        userInfoDTO.setUsername(user.getUsername());
        return userInfoDTO;
    }

    private String encodePassword(String password) {return passwordEncoder.encode(password);}
    private boolean checkUserExists(String username) {return userRepository.existsByUsername(username);}

}
