package com.stone.will.demo.model;

import javax.persistence.*;

@Entity(name="PASSWORDS")
public class WebSitePassword {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private ActiveUser owner;

    @Column(nullable = false, unique = true)
    private String website;

    @Column(nullable = false)
    private String password;

    public ActiveUser getOwner() {
        return owner;
    }

    public void setOwner(ActiveUser owner) {
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public WebSitePassword(int id, String website, String password) {
        this.id = id;
        this.website = website;
        this.password = password;
    }

    public WebSitePassword() {
    }
}
