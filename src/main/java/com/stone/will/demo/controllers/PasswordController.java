package com.stone.will.demo.controllers;

import com.stone.will.demo.DTO.GetPasswordRequest;
import com.stone.will.demo.DTO.WebsitePasswordDTO;
import com.stone.will.demo.model.WebSitePassword;
import com.stone.will.demo.services.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passwords")
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @GetMapping("/get")
    public ResponseEntity<WebsitePasswordDTO> getPassword(@RequestBody GetPasswordRequest passwordRequest){
        ResponseEntity<WebsitePasswordDTO> response = new ResponseEntity(passwordService.getPassword(passwordRequest), HttpStatus.OK);
        return response;
    }

    @PostMapping("/create")
    public ResponseEntity<WebsitePasswordDTO> addPassword(@RequestBody WebSitePassword password, @RequestParam String username){
        ResponseEntity<WebsitePasswordDTO> response = new ResponseEntity<WebsitePasswordDTO>(passwordService.addPassword(username, password), HttpStatus.CREATED);
        return response;
    }

    @DeleteMapping("/delete")
    public ResponseEntity deletePassword(@RequestParam String website, @RequestParam String username){
        passwordService.deletePassword(username, website);

        return new ResponseEntity(HttpStatus.OK);
    }
}
