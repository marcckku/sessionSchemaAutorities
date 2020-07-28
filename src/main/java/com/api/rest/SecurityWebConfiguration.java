/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest;

import com.api.rest.service.LoginUtenteDetailsService;
import com.api.rest.service.UserServiceDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 *
 * @author marco
 *
 * https://www.baeldung.com/spring-boot-security-autoconfiguration
 *
 * L' annotazione @EnableWebSecurity è fondamentale se disabilitiamo la
 * configurazione di sicurezza predefinita. Se mancante, l'applicazione non
 * verrà avviata.
 *
 * L'annotazione è facoltativa solo se stiamo semplicemente ignorando il
 * comportamento predefinito utilizzando un WebSecurityConfigurerAdapter
 *
 *
 *
 */
////////////////////////QUESTA CONFIG E' PER AVERE UNA SESSION WEB DI UN
/////////////////////// UTENTE LOGGATO 
@Slf4j
@RequiredArgsConstructor
@Configuration()
@EnableWebSecurity ///--->> Questa annotazione permette di abilitare OAuth 2.0 login attraverso httpSecurity.oauth2Login():
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true) // proxyTargetClass = true -->> serve alla config di OAuth
public class SecurityWebConfiguration extends WebSecurityConfigurerAdapter {

  //  private static final Logger logger = LoggerFactory.getLogger(SecurityWebConfiguration.class); /// sostituita da  @Slf4j

    ///api/rest/login/getAllLogins
    /////////////// IN QUESTO CASO L'ORDINE CONTA MOLTO - COSI QUANDO FARAI IL LOGIN NON AVRAI PROBLEMI DI AUTORITA (RUOLO) INQUANTO AI DUE LOGIN DIVERSI.
    /////////////// 1)  auth.authenticationProvider(authenticationProviderLogin()); --> user
    //////////////  2)  auth.authenticationProvider(authenticationProvider())  --> loginUtente
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth); //To change body of generated methods, choose Tools | Templates.
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();///hash di password adattivo unidirezionale (ovvero bCrypt, PBKDF2, SCrypt, ecc.
        auth.authenticationProvider(authenticationProviderLogin()); /// carico dal db User.
        auth.authenticationProvider(authenticationProvider()); /// carico dal db  LoginUtente   

        log.info("\n\n authenticationProviderLogin() " + authenticationProviderLogin().toString() + "\n\n");
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(myUserDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProviderLogin() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsServiceLogin());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public UserDetailsService myUserDetailsService() {
        return new LoginUtenteDetailsService(); ///////////////  <<<<<<<<< ------ CARICO USER DAL DB 
    }

    @Bean
    public UserDetailsService userDetailsServiceLogin() {
        return new UserServiceDetailService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    
    
    
     /* 
      ################### Mapping Resources Configuration - FREE MAKER ##########################
        https://freemarker.apache.org/
        ### FreeMarker è un motore di template Java lato server per ambienti web e standalone. 
        ##  I modelli sono scritti in FreeMarker Template Language (FTL), che è un linguaggio semplice e specializzato.
    
        FreeMarkerViewResolver deve essere configurato con i valori richiesti 
        che verranno utilizzati in fase di esecuzione.Ad esempio, configureremo il risolutore di viste per utilizzare 
        FreeMarker per le viste che terminano con .ftl:
     * @return 
     */
    @Bean
    public FreeMarkerViewResolver freemarkerViewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setCache(true);
        resolver.setPrefix("");
        resolver.setSuffix(".ftlh");
        return resolver;
    }

    /* FreeMarker Template Path Configuration */
    @Bean
    public FreeMarkerConfigurer freemarkerConfig() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/views/ftl/");
        return freeMarkerConfigurer;
    }
    
    
    
    
    
    
    
    ////////////////// CREA UN USER INCOLANDO L'URL QUI SOTTO 
    /////////////////
    /////////////////   http://localhost:8786/create/admin/admin@gmail.com/admin
    /////////////////   http://localhost:8786/create/user/user@gmail.com/user
    /////////////////  1) ADMIN ::  username: admin@gmail.com  con password: admin enabled=1    role:ROLE_ADMIN
    /////////////////  2) USER  ::  username: root2@gmail.com  con password: user  enabled=1    role:ROLE_USER
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // super.configure(http); //To change body of generated methods, choose Tools | Templates.
        http
                .authorizeRequests()
                .mvcMatchers("/home/**").permitAll() //permette un URL Specifico, senza usare credenziali.
                .mvcMatchers("/create/**").permitAll() //permette un URL Specifico, senza usare credenziali.
                //.antMatchers("/authenticate").permitAll()
                .mvcMatchers("/loginUtentes/**").access("hasRole('ADMIN')")
                .mvcMatchers("/utentes/**").access("hasRole('ADMIN')")
                .antMatchers("/actuator/**", "/api/rest/**", "/oauth/*").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/**").hasAnyAuthority("ROLE_ADMIN") // Solo da Users Autenticati
                //.antMatchers("/loginUtentes/**").authenticated() // Solo da Users Autenticati
                .antMatchers(
                        //HttpMethod.GET,
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js"
                ).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403");

    }

}
