package com.stone.will.demo.controllers;

import com.stone.will.demo.DTO.WebsitePasswordDTO;
import com.stone.will.demo.model.WebSitePassword;
import com.stone.will.demo.services.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @GetMapping("/passwords/all")
    public List<WebSitePassword> getAll(){
        return passwordService.listAll();
    }

    @PostMapping("/passwords/create")
    public ResponseEntity<WebsitePasswordDTO> addPassword(@RequestBody WebSitePassword password, @RequestParam String username){
        ResponseEntity<WebsitePasswordDTO> response = new ResponseEntity<WebsitePasswordDTO>(passwordService.addPassword(username, password), HttpStatus.CREATED);
        return response;
    }

    @DeleteMapping("/passwords/delete")
    public ResponseEntity deletePassword(@RequestParam String website, @RequestParam String username){
        passwordService.deletePassword(username, website);

        return new ResponseEntity(HttpStatus.OK);
    }
}
