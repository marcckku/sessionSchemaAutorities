/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.userDetailsImpl;

import com.api.rest.model.LoginUtente;
import java.util.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author marco
 */
@Slf4j
public class MyLoginUtentePrincipal implements UserDetails {
    

    private final LoginUtente loginUtente;
    String ROLE_PREFIX = "ROLE_";
   public MyLoginUtentePrincipal(LoginUtente _loginUtente) {
        this.loginUtente = _loginUtente;
    }

    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role = loginUtente.getRole();
        List<GrantedAuthority> list = new ArrayList<>();
        String noPrefix = role.split(ROLE_PREFIX)[1];//USER

        log.info(" ==========  role   =============== " + role);
        log.info(" ==========  noPrefix   =============== " + noPrefix);
        boolean hasForm_ROLE_X = role.split(ROLE_PREFIX).length >= 2; //VUOL DIRE CHE è GIA FORMATO ROLE_ADMIN, ROLE_USER ECCC...
        if (!hasForm_ROLE_X) {
            list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role));
        }else{
          System.out.println(" ==========  role   =============== " + role);
          list.add(new SimpleGrantedAuthority(role));

        }
        log.info("\n\n loginUtente.getRole() \n\n" + role + "\n\n");
        log.info("\n\n list.get(0)  \n\n" + list.get(0) + "\n\n");

        return list;
    }


    
    
    
 
    @Override
    public String getPassword() {
        return loginUtente.getPassword();
    }
 
    @Override
    public String getUsername() {
        return loginUtente.getEmail();
    }
 
  @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return loginUtente.isEnabled();
    }
    
 /*    */




}