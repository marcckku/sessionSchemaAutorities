/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.controller;

import com.api.rest.model.LoginUtente;
import com.api.rest.repository.LoginUtenteRepository;
import java.sql.Timestamp;
import java.util.Date;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author marco
 */
@RestController
@RequestMapping("/create/")
public class CreateUserController {

    @Autowired// JpaRepository
    LoginUtenteRepository loginRepository;

    @GetMapping("/admin/{email}/{password}")
    public ResponseEntity createAdmin(@PathVariable String email, @PathVariable String password) {// @Valid @RequestBody LoginUtente loginUtente
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();///hash di password adattivo unidirezionale (ovvero bCrypt, PBKDF2, SCrypt, ecc.
        LoginUtente lu = new LoginUtente();
        lu.setEmail(email);
        lu.setEnabled(true);
        lu.setPassword(encoder.encode(password));
        lu.setRole("ROLE_ADMIN");
        Date date = new Date();
        lu.setStartLogin(new Timestamp(date.getTime()));

        return ResponseEntity.ok(loginRepository.save(lu));
    }

    
     @GetMapping("/user/{email}/{password}")
    public ResponseEntity createNormalUser(@PathVariable String email, @PathVariable String password) {// @Valid @RequestBody LoginUtente loginUtente
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();///hash di password adattivo unidirezionale (ovvero bCrypt, PBKDF2, SCrypt, ecc.
        LoginUtente lu = new LoginUtente();
        lu.setEmail(email);
        lu.setEnabled(true);
        lu.setPassword(encoder.encode(password));
        lu.setRole("ROLE_USER");
        Date date = new Date();
        lu.setStartLogin(new Timestamp(date.getTime()));

        return ResponseEntity.ok(loginRepository.save(lu));
    }

    
    
}
