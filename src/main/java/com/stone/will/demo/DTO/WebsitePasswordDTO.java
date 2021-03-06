package com.stone.will.demo.DTO;

import com.stone.will.demo.model.WebSitePassword;

public class WebsitePasswordDTO {
    private int id;

    private String website;

    private String password;

    public WebsitePasswordDTO(WebSitePassword password) {
        this.id = password.getId();
        this.website = password.getWebsite();
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
}
