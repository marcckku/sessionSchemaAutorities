/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.controller;

/**
 *
 * @author marco
 */

import com.api.rest.SecurityWebConfiguration;
import com.api.rest.model.Prodotto;
import com.api.rest.repository.ProdottoRepository;
import java.util.HashMap;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path="/home/")
@Slf4j
@RequiredArgsConstructor
public class HomeControllerForTesting {
    
      //  private static final Logger logger = LoggerFactory.getLogger(SecurityWebConfiguration.class);

   //  @JsonCreator
    @GetMapping({"/hello", "/hello/HomeControllerForTesting"})
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
         log.info("\n Endpoint hello\n");
        return "hello";
    }
    
    
    
    @GetMapping({"/home_"})
    public String home(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "home";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Autowired// JpaRepository
    ProdottoRepository prodottoRepository;


    
    @RequestMapping(value = "/prodotti", method = RequestMethod.GET)
    public ModelAndView prodotti() {//(@ModelAttribute("model") ModelMap model
        List<Prodotto> prodotti = prodottoRepository.findAll();

        HashMap<String, Object> myHashMapProdotti = new HashMap<String, Object>();
        myHashMapProdotti.put("prodotti", prodotti);

        if (prodotti == null) {
            log.info("\n Endpoint prodotti, prodotti=null \n");
        }

      // model.addAttribute("prodotti", myHashMapProdotti);
       // return "prodotti";
       return new ModelAndView("prodotti",myHashMapProdotti);
    }
    
    
    
    
}