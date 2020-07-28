/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.controller;

import com.api.rest.model.LoginUtente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.rest.repository.LoginUtenteRepository;
import java.util.Optional;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author marco
 */
@RestController
@RequestMapping(path = "/api/rest/login")
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    
    @Autowired// JpaRepository
    LoginUtenteRepository loginRepository;

    //api/rest/login/getAllLogins
    // @CrossOrigin(origins = "http://localhost:51170/#/")///flutter 
    @GetMapping("/getAllLogins")
    public ResponseEntity<List<LoginUtente>> findAll() {
        // return ResponseEntity.ok((List<LoginUtente>)loginDao.findAll()   );     //  CrudRepository
        return ResponseEntity.ok((List<LoginUtente>) loginRepository.findAll());  // JpaRepository
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoginUtente> findById(@PathVariable Long id) {
        Optional<LoginUtente> stock = loginRepository.findById(id);
        if (!stock.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoginUtente> update(@PathVariable Long id, @Valid @RequestBody LoginUtente loginUtente) {
        if (!loginRepository.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(loginRepository.save(loginUtente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!loginRepository.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        loginRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
