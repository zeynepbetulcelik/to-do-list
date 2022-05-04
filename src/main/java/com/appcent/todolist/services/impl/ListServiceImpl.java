package com.appcent.todolist.services.impl;

import com.appcent.todolist.entities.ToDoList;

import com.appcent.todolist.entities.User;
import com.appcent.todolist.model.ListResponseModel;
import com.appcent.todolist.model.ToDoListDTO;
import com.appcent.todolist.repositories.ToDoListRepository;
import com.appcent.todolist.repositories.UserRepository;
import com.appcent.todolist.services.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ListServiceImpl implements ListService {

    private final ToDoListRepository toDoListRepository;
    private final UserRepository userRepository;

    @Override
    public List<ToDoListDTO> getAllLists() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<ToDoList> toDoLists = toDoListRepository.getListsByUsername(username);
        List<ToDoListDTO> toDoListDTOS = new ArrayList<>();
        for (ToDoList toDoList : toDoLists) {
            ToDoListDTO toDoListDTO = new ToDoListDTO();
            BeanUtils.copyProperties(toDoList, toDoListDTO);
            toDoListDTOS.add(toDoListDTO);
        }
        return toDoListDTOS;
    }

    @Override
    @Transactional
    public ListResponseModel createToDoList(ListResponseModel listResponseModel) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username).orElse(null);
        ToDoList toDoList = new ToDoList();
        toDoList.setCategory(listResponseModel.getCategory());
        toDoList.setComplete(false);
        toDoList.setName(listResponseModel.getName());
        toDoList.setUser(user);
        toDoListRepository.save(toDoList);
        return new ListResponseModel(toDoList.getCategory(), toDoList.getName(), toDoList.isComplete(), toDoList.getId());
    }

    @Override
    @Transactional
    public ListResponseModel updateToDoList(UUID id) {
        ToDoList toDoList = toDoListRepository.findById(id).orElse(null);
        if (toDoList == null) {
            throw new RuntimeException("id is not valid");
        } else {
            toDoListRepository.updateToDoList(id);
            return new ListResponseModel(toDoList.getCategory(), toDoList.getName(), true, toDoList.getId());
        }

    }

    @Override
    @Transactional
    public boolean deleteToDoListById(UUID id) {
        try {
            toDoListRepository.deleteById(id);
            return true;
        } catch (RuntimeException e) {
            throw new RuntimeException("id is not valid");
        }

    }
}
