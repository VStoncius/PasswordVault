package com.stone.will.demo.model;

import com.stone.will.demo.DTO.AuthenticationRequest;
import com.stone.will.demo.DTO.UserDTO;

import javax.persistence.*;
import java.util.Set;

@Entity(name="USERS")
public class ActiveUser {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "owner", orphanRemoval= true)
    private Set<WebSitePassword> content;

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

    public Set<WebSitePassword> getContent() {
        return content;
    }

    public void setContent(Set<WebSitePassword> content) {
        this.content = content;
    }

    public ActiveUser(AuthenticationRequest authenticationRequest) {
        this.username = authenticationRequest.getUsername();
        this.password = authenticationRequest.getPassword();
    }

    public ActiveUser() {
    }
}
