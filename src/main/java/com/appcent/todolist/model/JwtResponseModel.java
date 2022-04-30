package com.appcent.todolist.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class JwtResponseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String token;

}