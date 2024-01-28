package com.tweteroo.api.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.DTOs.UserDTO;
import com.tweteroo.api.Models.UserModel;
import com.tweteroo.api.Services.UserService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {
    
    final UserService userService;

    public UserController (UserService userService){
        this.userService= userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserModel>> getUsers() {
        List<UserModel> users= userService.findUsers();

        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping()
    public ResponseEntity<Object> postUser(@RequestBody @Valid UserDTO userDTO){
        Optional<UserModel> user= userService.createUsers(userDTO);

        if(user.isEmpty()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Existing username.");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
