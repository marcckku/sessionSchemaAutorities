/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author marco
 */


@Entity(name = "Login")
//@Table(name = "Login")
@Data()
@Slf4j
public class LoginUtente implements Serializable {

        private static final long serialVersionUID = 5057388942388599425L;

    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    
    @Column(length = 30, nullable = false , unique = true)
    private String email;
    
    @Column(length = 100, nullable = true , unique = false)
    private String password;
    
     @Column( nullable = true , unique = false)
  //  @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Timestamp startLogin;
    
   // @Column( nullable = true , unique = false)
  //  @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Timestamp endLogin;

    @Column(length = 50)
    private String role;
    
    
     private boolean enabled;
    
    
    private String token;
    
    
    
    
    
    ///non sono necessari perchè Lombok  genera getter e setter di campo per te..
/*
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getStartLogin() {
        return startLogin;
    }

    public void setStartLogin(Date startLogin) {
        this.startLogin = startLogin;
    }

    public Date getEndLogin() {
        return endLogin;
    }

    public void setEndLogin(Date endLogin) {
        this.endLogin = endLogin;
    }

    public String getRouolo() {
        return ruolo;
    }

    public void setRouolo(String rouolo) {
        this.ruolo = rouolo;
    }
    */
    
    
    

}
