package com.appcent.todolist.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class ErrorDto {

    /**
     * Enhance errorDto, more Details like status can be attached under Dto
     */

    private String message;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorDto errorDto = (ErrorDto) o;
        return Objects.equals(message, errorDto.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}