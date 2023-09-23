package com.example.ulbitvsspring.entity;

import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    public List<TodoEntity> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoEntity> todos) {
        this.todos = todos;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user") /* цим каскадом ми оповіщуємо що якщо
     ми видаляємо юзера то треба видалити зразу всі задачі які привязані до цього користувача */
    //mappedBy - later
    private List<TodoEntity> todos;


    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
