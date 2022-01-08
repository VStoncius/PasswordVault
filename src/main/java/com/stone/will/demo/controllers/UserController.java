package com.stone.will.demo.controllers;

import com.stone.will.demo.model.ActiveUser;
import com.stone.will.demo.model.WebSitePassword;
import com.stone.will.demo.services.PasswordService;
import com.stone.will.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/find")
    public ActiveUser getUser(@RequestParam String username){
        return userService.getUser(username);
    }

    @PostMapping("/users/create")
    public ResponseEntity createUser(@RequestBody ActiveUser newUser){
        userService.saveUser(newUser);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
