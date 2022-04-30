package com.appcent.todolist.controller;


import com.appcent.todolist.model.ListResponseModel;
import com.appcent.todolist.model.ToDoListDTO;

import com.appcent.todolist.services.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/list")
public class ListController {
    private final ListService listService;
    @PostMapping("/to-do-list")
    public ResponseEntity<ListResponseModel> createlist(@RequestBody ToDoListDTO toDoListDTO)  {
        return ResponseEntity.status(HttpStatus.OK).body(listService.createToDoList(toDoListDTO));
    }
    @GetMapping("/to-do-list")
    public ResponseEntity<List<ToDoListDTO>> getToDoLists()  {
        return ResponseEntity.status(HttpStatus.OK).body(listService.getAllLists());
    }

    @PutMapping("/to-do-list")
    public ResponseEntity<ListResponseModel> updateList(@RequestParam("id") UUID id)  {
        return ResponseEntity.status(HttpStatus.CREATED).body(listService.updateToDoList(id));
    }

}
