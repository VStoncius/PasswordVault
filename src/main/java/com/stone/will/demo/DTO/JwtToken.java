package com.stone.will.demo.DTO;

public class JwtToken {

    private final String jwttoken;

    public JwtToken(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }
}
