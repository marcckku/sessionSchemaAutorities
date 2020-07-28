/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest;


import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;



/**
 *
 * @author marco
 */


/**
 
 * Un altro approccio utile è non avviare affatto il server ma testare solo il 
 * livello sottostante, dove Spring gestisce la richiesta HTTP in arrivo e la 
 * passa al controller. In questo modo, viene utilizzato quasi l'intero stack 
 * e il codice verrà chiamato esattamente come se stesse elaborando una 
 * richiesta HTTP reale ma senza i costi di avvio del server. Per fare ciò, usa
 * Spring's MockMvce chiedi che ti venga iniettato usando l'annotazione
 * @AutoConfigureMockMvc sul test case. Il seguente elenco 
 * (src/test/java/com/api/rest/ClassExampleTest02.java):)
 * mostra come farlo:
 
 
 */

//Web

@SpringBootTest
@AutoConfigureMockMvc
public class ClassExampleTest02 {
    
    
    
    @Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/loginUtentes?page=1")).andDo(print()).andExpect(status().isOk());
				//.andExpect(content().string(containsString("Hello, World")));
	}
}
