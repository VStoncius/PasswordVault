package com.stone.will.demo.DTO;

import com.stone.will.demo.model.ActiveUser;

public class UserDTO {
    private String username;

    private String password;

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDTO(ActiveUser user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
