/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest;




import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;


/**
 *
 * @author marco
 * 
 * https://spring.io/guides/gs/testing-web/
 * 
 * 
 * Test esempio 2
 * 
 * È bello avere un controllo di integrità, ma dovresti anche scrivere alcuni 
 * test che affermano il comportamento della tua applicazione. 
 * 
 * Per fare ciò, è possibile avviare l'applicazione e ascoltare una connessione 
 * (come farebbe in produzione) e quindi inviare una richiesta HTTP e affermare 
 * la risposta. 
 * 
 * Il seguente elenco (src/test/java/com/api/rest/ClassExampleTest01.java):) mostra come farlo:
 * 
 */




@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ClassExampleTest01 {
    
    
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
            assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/hello/HomeControllerForTesting", String.class))
                    .contains("Hello, World");
    }
    
}


/*

Si noti l'uso di webEnvironment=RANDOM_PORTper avviare il server con una porta 
casuale (utile per evitare conflitti negli ambienti di test) e l'iniezione 
della porta con @LocalServerPort. Inoltre, tieni presente che Spring Boot ti ha 
fornito automaticamente una TestRestTemplate. Tutto quello che devi fare è 
aggiungerlo @Autowired.


**/