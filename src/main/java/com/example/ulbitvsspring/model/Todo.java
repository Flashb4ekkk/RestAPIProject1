package com.example.ulbitvsspring.model;

import com.example.ulbitvsspring.entity.TodoEntity;
import org.springframework.ui.Model;

public class Todo {
    private Long id;
    private String title;
    private Boolean completed;

    public static Todo toModel(TodoEntity entity){
        Todo model = new Todo();
        model.setId(entity.getId());
        model.setCompleted(entity.getCompleted());
        model.setTitle(entity.getTitle());
        return model;
    }

    public Todo (){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String username) {
        this.title = title;
    }

//    public boolean getCompleted() {
//        return completed;
//    }
    public boolean getCompleted() {
        return completed != null ? completed : false; // Повертає false, якщо completed == null
    }


    public void setCompleted(Boolean username) {
        this.completed = completed;
    }
}
