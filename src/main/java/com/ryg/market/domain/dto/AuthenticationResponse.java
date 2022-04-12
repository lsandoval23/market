package com.ryg.market.domain.dto;

public class AuthenticationResponse {

    private String jwt;

    // Constructor

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    // Getters and setter

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
