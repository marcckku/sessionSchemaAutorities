/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.service;
import com.api.rest.model.Utente;
import com.api.rest.repository.UtenteRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;





/**
 *
 * @author marco
 * 
   Per le classi che hanno un solo costruttore, a partire dalla versione spring
 * 4.3, non è più necessario specificare un'annotazione esplicita per
 * l'iniezione come @Autowired, Spring lo fa per te...
 *
 *
 *
 * Se il tuo editor non è stato installato plugin Lombok, potresti ricevere un
 * errore evidenziato nel campo UtenteRespository. Compilare il progetto o
 * installare il plugin risolverà il problema.
 */

@Service
@RequiredArgsConstructor
public class UtenteService {
    
    
    private final UtenteRespository utenteRespository;///////////NON C'E BISOGNO DEL @Autowired dalla v. Spring 4 in avanti

    
    private static final long serialVersionUID = 1L;

    public List<Utente> findAll() {
        return utenteRespository.findAll();
    }

    public Optional<Utente> findById(Long id) {
        return utenteRespository.findById(id);
    }

    public Utente save(Utente stock) {
        return utenteRespository.save(stock);
    }

    public void deleteById(Long id) {
        utenteRespository.deleteById(id);
    }
   
    
    
}
