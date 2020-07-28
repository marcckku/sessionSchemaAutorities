package com.api.rest;

import com.api.rest.model.Authority;
import com.api.rest.model.AuthorityName;
import com.api.rest.model.User;
import com.api.rest.repository.AuthorityRepository;
import com.api.rest.repository.UserRepository;
import java.util.Arrays;
import java.util.List;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SessionSchemaAutoritiesApplication {

    @Autowired
    private DataSource datasource;
    @Autowired
    private ApplicationContext webApplicationContext;

    @Autowired
    PasswordEncoder passwordEncoder;

    
    
    private static final Logger logger = LoggerFactory.getLogger(SecurityWebConfiguration.class);

    
    ///////////////////// CARICA USERS NEL DB CON RISPETTIVO RUOLO..
    @Bean
    public CommandLineRunner loadData(UserRepository userRepository, AuthorityRepository authorityRepository) {
        return (args) -> {

            User user = userRepository.findByUsername("admin");

            if (user == null) {

                /**
                 * Inizializzo i dati del mio test
                 */
                ///username=admin
                //password=admin
                Authority authorityAdmin = new Authority();
                authorityAdmin.setName(AuthorityName.ROLE_ADMIN);
                authorityAdmin = authorityRepository.save(authorityAdmin);

                Authority authorityUser = new Authority();
                authorityUser.setName(AuthorityName.ROLE_USER);
                authorityUser = authorityRepository.save(authorityUser);

                List<Authority> authorities = Arrays.asList(new Authority[]{authorityAdmin, authorityUser});

                user = new User();
                user.setAuthorities(authorities);//// carico l'insieme di authorities..
                user.setEnabled(true);
                user.setUsername("admin");
                user.setPassword(passwordEncoder.encode("admin"));

                user = userRepository.save(user);
                
                logger.info("\n User creato con authority ROLE_ADMIN e ROLE_USER \n");
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SessionSchemaAutoritiesApplication.class, args);
    }

}
