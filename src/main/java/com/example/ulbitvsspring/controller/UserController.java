package com.example.ulbitvsspring.controller;

import com.example.ulbitvsspring.entity.UserEntity;
import com.example.ulbitvsspring.exception.UserAlreadyExistException;
import com.example.ulbitvsspring.exception.UserNotFoundException;
import com.example.ulbitvsspring.repository.UserRepo;
import com.example.ulbitvsspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("user is successful save");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("exception");
        }
    }

    @GetMapping()
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getOne(id));
        }catch(UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("exception");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.delete(id));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("exception");
        }
    }
}
