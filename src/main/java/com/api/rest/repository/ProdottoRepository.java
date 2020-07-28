/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.repository;

import com.api.rest.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author marco
 */

////////vuoto perche spring implementa i metodi per le operazionei CRUD.
public interface ProdottoRepository  extends JpaRepository<Prodotto, Long>{
    
}
