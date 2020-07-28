/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.repository;

import com.api.rest.model.LoginUtente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author marco
 */

//@Transactional
public interface LoginDao extends CrudRepository<LoginUtente, Long> {
    
    
    
}
