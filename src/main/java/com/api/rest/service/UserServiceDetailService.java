/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.service;

import com.api.rest.model.User;
import com.api.rest.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.api.rest.userDetailsImpl.MyUserPrincipal;

/**
 *
 * @author marco
 */
/**
 *
 * @author marco
 *
 * Per le classi che hanno un solo costruttore, a partire dalla versione spring
 * 4.3, non è più necessario specificare un'annotazione esplicita per
 * l'iniezione come @Autowired, Spring lo fa per te...
 *
 *
 *
 * Se il tuo editor non è stato installato plugin Lombok, potresti ricevere un
 * errore evidenziato nel campo UtenteRespository. Compilare il progetto o
 * installare il plugin risolverà il problema.    UserRepository usersRepository;

    private static final long serialVersionUID = 1L;
 */
@Service
@RequiredArgsConstructor
public class UserServiceDetailService implements UserDetailsService{
    
    
     @Autowired
    UserRepository usersRepository;
 
    @Override
    public UserDetails loadUserByUsername(String username) {
        User _loginUtente = usersRepository.findByUsername(username);
        if (_loginUtente == null) {
           throw new UsernameNotFoundException("Could not find user nel db!!");
        }
        return new MyUserPrincipal(_loginUtente);
    }
    
 
    
    
}