package com.stone.will.demo.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name="PASSWORDS")
public class WebSitePassword {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String websiteName;

    @Column(nullable = false)
    String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public WebSitePassword(int id, String websiteName, String password) {
        this.id = id;
        this.websiteName = websiteName;
        this.password = password;
    }

    public WebSitePassword() {
    }
}
