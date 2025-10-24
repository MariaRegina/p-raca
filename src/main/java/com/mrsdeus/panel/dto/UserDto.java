package com.mrsdeus.panel.dto;

import com.mrsdeus.panel.persistence.entities.User;

public class UserDto {

    private String email;
    private String password;
    private Boolean remember_me;
    private String path_avatar;

    public UserDto(){}

    private UserDto(User user){
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.path_avatar = user.getPath_avatar();
        this.remember_me = user.getRemember_me();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRemember_me() {
        return remember_me;
    }

    public void setRemember_me(Boolean remember_me) {
        this.remember_me = remember_me;
    }

    public String getPath_avatar() {
        return path_avatar;
    }

    public void setPath_avatar(String path_avatar) {
        this.path_avatar = path_avatar;
    }
}
