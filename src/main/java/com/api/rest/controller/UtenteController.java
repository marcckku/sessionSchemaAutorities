/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.controller;



import com.api.rest.model.Utente;
import com.api.rest.service.UtenteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 *
 * @author marco
 */






@RestController
@RequestMapping("/api/rest/utente")
@Slf4j
@RequiredArgsConstructor
public class UtenteController {
    
   //  @Autowired //da spring 4 in avanti Spring mette l'@Autowired per te... In questo caso non c'e bisogno 
     private final UtenteService utenteService;
    
    
    // @CrossOrigin(origins = "http://localhost:51170/#/")///flutter 
     @GetMapping( "/getAllUtenti")
    public ResponseEntity<List<Utente>> findAll() {
        log.info("\n End point findAll\n");
        return ResponseEntity.ok(utenteService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Utente product) {
        return ResponseEntity.ok(utenteService.save(product));
    }

   // @Secured({ "ROLE_ADMIN" })
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')") // SOLO DA USER AUTENTICATO 
    @GetMapping("/get/user/{id}")
    public ResponseEntity<Utente> findById(@PathVariable Long id) {
                System.out.print( "\n ============= LONG ID " + id );
        Optional<Utente> stock = utenteService.findById(id);
        if (!stock.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Utente> update(@PathVariable Long id, @Valid @RequestBody Utente product) {
        if (!utenteService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(utenteService.save(product));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!utenteService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        utenteService.deleteById(id);

        return ResponseEntity.ok().build();
    }
    
    
    
    
}
