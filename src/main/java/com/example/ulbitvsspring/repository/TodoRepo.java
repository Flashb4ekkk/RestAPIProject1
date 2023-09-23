package com.example.ulbitvsspring.repository;

import com.example.ulbitvsspring.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
}
