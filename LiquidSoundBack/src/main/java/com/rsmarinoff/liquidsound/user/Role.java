/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsmarinoff.liquidsound.user;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author User
 */
@Entity
@Data
public class Role implements GrantedAuthority, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userRole;

    protected Role() {

    }

    public Role(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String getAuthority() {
        return userRole;
    }

}
