/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.service;

import com.api.rest.model.Prodotto;
import com.api.rest.repository.ProdottoRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author marco
 */
/**
 *
 * RequiredArgsConstructor è un'annotazione di Lombok che genera un costruttore
 * con campi obbligatori (campi finali e campi @NonNull). Per la classe
 * UtenteService, Lombok genererà :
 *
 * @Service public class ProductService { private final ProductRespository
 * productRespository;
 *
 * public ProductService(ProductRespository productRespository) {
 * this.productRespository = productRespository; }
 *
 * ... }
 *
 * Per le classi che hanno un solo costruttore, a partire dalla versione spring
 * 4.3, non è più necessario specificare un'annotazione esplicita per
 * l'iniezione come @Autowired, Spring lo fa per te...
 *
 *
 *
 * Se il tuo editor non è stato installato plugin Lombok, potresti ricevere un
 * errore evidenziato nel campo UtenteRespository. Compilare il progetto o
 * installare il plugin risolverà il problema.
 *
 *
 *
 *
 */
@Service
@RequiredArgsConstructor
public class ProdottoService {

    private static final long serialVersionUID = 1L;

    //Grazie a @RequiredArgsConstructor non c'è bisogno di @Autowired
    private final ProdottoRepository prodottoRepository;

    public List< Prodotto> findAll() {
        return prodottoRepository.findAll();
    }

    public Optional< Prodotto> findById(Long id) {
        return prodottoRepository.findById(id);
    }

    public Prodotto save(Prodotto stock) {
        return prodottoRepository.save(stock);
    }

    public void deleteById(Long id) {
        prodottoRepository.deleteById(id);
    }

}
