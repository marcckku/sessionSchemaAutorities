/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.service;

import com.api.rest.model.LoginUtente;
import com.api.rest.userDetailsImpl.MyLoginUtentePrincipal;
import com.api.rest.repository.LoginUtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author marco
 * 
 * https://www.baeldung.com/spring-security-authentication-with-a-database
 * 
 * 6.1. Configurazione annotazione
 * Tutto ciò che dobbiamo fare per abilitare il nostro UserDetailsService  personalizzato è aggiungerlo al nostro contesto applicativo come bean.
 * 
 * Poiché abbiamo configurato la nostra classe con l' annotazione @Service, l'applicazione la rileverà automaticamente (come un bean) durante la 
 * scansione dei componenti (@Service = stereotipe = @Component) e creerà un bean fuori da questa classe. Pertanto, non c'è nient'altro che dobbiamo 
 * fare qui.
 * 
 * 
 * 
 * nota:
 * 
 * Se abbiamo bisogno, comunque, di un livello più elevato di flessibilità, personalizzando esattamente il modo in cui l'applicazione 
 * recupererà i dettagli dell'utente, sceglieremo l'approccio seguito in questo tutorial.
 */

@Service
public class LoginUtenteDetailsService implements UserDetailsService{
    
    
     @Autowired
    private LoginUtenteRepository loginUtenteRepository;
 
    @Override
    public UserDetails loadUserByUsername(String email) {
        LoginUtente _loginUtente = loginUtenteRepository.findByEmail(email);
        if (_loginUtente == null) {
           throw new UsernameNotFoundException("Could not find user - LA TUA EMAIL NEL DB");
        }
        return new MyLoginUtentePrincipal(_loginUtente);
    }
    
 
    
    
}
