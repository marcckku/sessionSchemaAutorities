/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.userDetailsImpl;

import com.api.rest.model.Authority;
import com.api.rest.model.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author marco
 */
@Slf4j
public class MyUserPrincipal implements UserDetails {

  //  private static final Logger logger = LoggerFactory.getLogger(MyUserPrincipal.class);

    
    private final User currentUser;
    

    public MyUserPrincipal(User currentUse) {
        this.currentUser = currentUse;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Authority> list = currentUser.getAuthorities();
        List<GrantedAuthority> auth = new ArrayList<>();
        
        list.stream().map((authority) -> {
            auth.add( new SimpleGrantedAuthority( authority.getName().toString()  )    ); /////// 
                return authority;
            }).forEachOrdered((authority) -> {
                log.info("\n\n  MyUserPrincipal::authority.getName().toString()   "  +      authority.getName().toString()    + "\n\n" );
            });
        
        
        
        
        return auth;
    }
  
 
    @Override
    public String getPassword() {
        return currentUser.getPassword();
    }
 
    @Override
    public String getUsername() {
        return currentUser.getUsername();
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
        return currentUser.getEnabled();
    }
}
