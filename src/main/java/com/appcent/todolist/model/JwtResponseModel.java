package com.appcent.todolist.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
@ApiModel(value = "Jwt response Api model documentation", description = "Model")
public class JwtResponseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "Token field of jwt response object for use in authorization bearer token " +
            "( it is required for todolist operations and user profile and valid for 100 minutes from the time of creation)")
    private final String token;

}