package com.stone.will.demo.DTO;

import com.stone.will.demo.model.ActiveUser;

public class UserDTO {
    private String username;

    private int id;

    public UserDTO(ActiveUser saveUser) {
        this.username = username;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
