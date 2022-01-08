package com.stone.will.demo.services;

import com.stone.will.demo.model.ActiveUser;
import com.stone.will.demo.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public ActiveUser getUser(String username) {
        return userRepo.findByUsername(username);
    }

    public ActiveUser saveUser(ActiveUser newUser) {
        return userRepo.save(newUser);
    }
}
