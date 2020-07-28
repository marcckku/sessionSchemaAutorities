/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author marco
 */

@Controller
@RequestMapping("/ftl/")
public class NoRestCotroller {
    
    
    @GetMapping(value="/helloFTL")
    public String helloFTL() {

      return "hello";
    }
    
    
}
