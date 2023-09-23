package com.example.ulbitvsspring.controller;

import com.example.ulbitvsspring.entity.TodoEntity;
import com.example.ulbitvsspring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo,
                                     @RequestParam Long userId){
        try {
            return ResponseEntity.ok(todoService.createTodo(todo, userId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("exception");
        }
    }

    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long id){
        try {
            return ResponseEntity.ok(todoService.complete(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("exception");
        }
    }

}
