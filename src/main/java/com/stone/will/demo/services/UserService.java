package com.stone.will.demo.services;

import com.stone.will.demo.DTO.UserDTO;
import com.stone.will.demo.model.ActiveUser;
import com.stone.will.demo.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public boolean isActiveUser(String username) {
        boolean exists = false;
        if (userRepo.findByUsername(username) != null){
            exists = true;
        }
        return exists;
    }
    public ActiveUser getUser(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ActiveUser user = userRepo.findByUsername(username);
        try {
            return new User(user.getUsername(), user.getPassword(),
                    new ArrayList<>());
        } catch (Exception e){
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public ActiveUser saveUser(UserDTO newUser) {
        newUser.setPassword(bCryptPasswordEncoder
                .encode(newUser.getPassword()));
        return userRepo.save(new ActiveUser(newUser));
    }
}
