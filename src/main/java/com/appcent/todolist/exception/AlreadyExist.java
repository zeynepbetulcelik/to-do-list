package com.appcent.todolist.exception;


public class AlreadyExist extends RuntimeException{

    public AlreadyExist(final String message) {
        super(message);
    }

}
