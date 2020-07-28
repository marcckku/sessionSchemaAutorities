/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest;

import com.api.rest.controller.HomeControllerForTesting;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author marco
 * 
 * 
 */





/**
 https://spring.io/guides/gs/testing-web/
 * 
 * * Test esempio 1
 * 
 L'annotazione @SpringBootTest dice a Spring Boot di cercare una classe di 
 configurazione principale (una con @SpringBootApplication, per esempio) e 
 di usarla per avviare un contesto di applicazione Spring. Puoi eseguire 
 questo test nel tuo IDE o dalla riga di comando (eseguendo ./mvnw test 
 * o ./gradlew test) e dovrebbe passare. Per convincerti che il contesto 
 sta creando il tuo controller, potresti aggiungere un'asserzione, come 
 mostrato nell'esempio seguente (src/test/java/com/api/rest/ClassExampleTest00.java):
 
 
 */


@SpringBootTest
public class ClassExampleTest00 {
    
    
	@Autowired
	private HomeControllerForTesting controller;

	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
  
    
}
