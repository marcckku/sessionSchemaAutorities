/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author marco
 */

@Entity
@Data
public class Prodotto implements Serializable{
    
    
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    //In questo modo ogni tabella avrà il suo ID univoco che inizia con 1,2,3 ... e così via. 
    // -->>    @GeneratedValue( strategy= GenerationType.SEQUENCE, generator="native") E  @GenericGenerator( name = "native",strategy = "native")
    //Per questo motivo, su qualsiasi database che non supporta le sequenze in modo nativo (ad esempio MySQL) utilizzeremo il generatore TABLE anziché IDENTITY . meglio  SEQU3ENCE
   
        private static final long serialVersionUID = 5057388942388599427L;

    
    //////////////////MIGLIOR MODO DI AVERE L'AUTOINCREMENT IN MYSQL 
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id; // LONG in mysql è bigint(20), questo per avere migliaia di tuple con id molto grandi.
    private String identificativo;
    private String nome;
    private double prezzo;
    private String descrizione;

        ///non sono necessari perchè Lombok (@Data) genera getter e setter  per te..
}
