package com.stone.will.demo.controllers;

import com.stone.will.demo.model.WebSitePassword;
import com.stone.will.demo.services.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @GetMapping("/passwords")
    public List<WebSitePassword> getAll(){
        return passwordService.listAll();
    }
}
