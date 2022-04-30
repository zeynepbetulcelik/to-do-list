package com.appcent.todolist.services;

import com.appcent.todolist.model.ListResponseModel;
import com.appcent.todolist.model.ToDoListDTO;

import java.util.List;
import java.util.UUID;

public interface ListService {
    List<ToDoListDTO> getAllLists();
    ListResponseModel createToDoList(ToDoListDTO toDoListDTO);
    ListResponseModel updateToDoList(UUID id);




}
