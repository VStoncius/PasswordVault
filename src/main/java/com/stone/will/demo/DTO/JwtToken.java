package com.stone.will.demo.DTO;

public class JwtToken {

    private final String jwtToken;

    public JwtToken(String jwttoken) {
        this.jwtToken = jwttoken;
    }

    public String getToken() {
        return this.jwtToken;
    }
}
