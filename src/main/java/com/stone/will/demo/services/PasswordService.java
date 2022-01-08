package com.stone.will.demo.services;

import com.stone.will.demo.DTO.WebsitePasswordDTO;
import com.stone.will.demo.model.ActiveUser;
import com.stone.will.demo.model.WebSitePassword;
import com.stone.will.demo.persistence.PasswordRepository;
import com.stone.will.demo.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordService {

    @Autowired
    private PasswordRepository passwordRepo;

    @Autowired
    private UserService userService;

    public List<WebSitePassword> listAll() {
        return passwordRepo.findAll();
    }

    public WebsitePasswordDTO addPassword(String username, WebSitePassword passwordForm) {
        try {
            passwordForm.setOwner(userService.getUser(username));
            passwordRepo.save(passwordForm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new WebsitePasswordDTO(passwordForm);
    }

    public void deletePassword(String username, String website) {
        try {
            ActiveUser user = userService.getUser(username);
            WebSitePassword tempPassword = passwordRepo.findByWebsite(website);
            if (tempPassword != null){
                if (tempPassword.getOwner().getId() == user.getId()){
                    passwordRepo.delete(tempPassword);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
