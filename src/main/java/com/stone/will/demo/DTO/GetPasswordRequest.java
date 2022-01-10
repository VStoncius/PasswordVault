package com.stone.will.demo.DTO;

public class GetPasswordRequest {

    private String website;
    private String username;

    public GetPasswordRequest(String website, String username) {
        this.website = website;
        this.username = username;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
