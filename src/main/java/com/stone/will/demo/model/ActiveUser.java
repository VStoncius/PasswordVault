package com.stone.will.demo.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name="USERS")
public class ActiveUser {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String username;

    @Column(nullable = false)
    String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ActiveUser(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public ActiveUser() {
    }
}
