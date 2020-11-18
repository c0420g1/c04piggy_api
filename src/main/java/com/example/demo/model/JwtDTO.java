package com.example.demo.model;

public class JwtDTO {
    private String accessToken;
    private String username;
    private String authorities;



    public JwtDTO(String accessToken, String username, String authorities) {
        this.accessToken = accessToken;
        this.username = username;
        this.authorities = authorities;

    }


    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}
