package com.example.ulbitvsspring.service;

import com.example.ulbitvsspring.controller.UserController;
import com.example.ulbitvsspring.entity.UserEntity;
import com.example.ulbitvsspring.exception.UserAlreadyExistException;
import com.example.ulbitvsspring.exception.UserNotFoundException;
import com.example.ulbitvsspring.model.User;
import com.example.ulbitvsspring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if(userRepo.findByUsername(user.getUsername()) != null) {
            throw  new UserAlreadyExistException("user with this username has already created");
        }
        return userRepo.save(user);
    }
    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if(user == null) {
            throw  new UserNotFoundException("user is not found");
        }
        return User.toModel(user);
    }
    public Long delete(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
