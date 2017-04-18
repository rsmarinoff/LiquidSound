/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsmarinoff.liquidsound.user;

import lombok.Data;

/**
 *
 * @author User
 */
@Data
public class UserDTO {

    private String username;
    private String password;
    private String[] roles;

    protected UserDTO() {

    }

    public UserDTO(String username, String password, String... roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
}
