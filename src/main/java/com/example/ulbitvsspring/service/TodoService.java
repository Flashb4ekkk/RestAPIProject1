package com.example.ulbitvsspring.service;

import com.example.ulbitvsspring.entity.TodoEntity;
import com.example.ulbitvsspring.entity.UserEntity;
import com.example.ulbitvsspring.model.Todo;
import com.example.ulbitvsspring.repository.TodoRepo;
import com.example.ulbitvsspring.repository.UserRepo;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userID){
        UserEntity user = userRepo.findById(userID).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo complete(Long id){
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));
    }
}
