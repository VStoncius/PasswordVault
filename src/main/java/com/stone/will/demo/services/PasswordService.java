package com.stone.will.demo.services;

import com.stone.will.demo.model.WebSitePassword;
import com.stone.will.demo.persistence.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordService {

    @Autowired
    private PasswordRepository passwordRepo;

    public List<WebSitePassword> listAll() {
        return passwordRepo.findAll();
    }
}
