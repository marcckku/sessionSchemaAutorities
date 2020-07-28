/*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
 */
package com.api.rest.model;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author marco
 */
/*
    @Data è un'annotazione di Lombok che genera getter e setter di campo, toString, uguale e metodi hashCode per te al momento della compilazione

    @Entity è un'annotazione JPA che specifica la classe come entità (quindi il nome della classe può essere utilizzato nelle query JPQL) e come tabella nel database
    **/
/**
 *
 * CREATE TABLE `utente` ( `id` bigint(20) NOT NULL, `cognme` varchar(255)
 * DEFAULT NULL, `nome` varchar(255) DEFAULT NULL, `telefono` int(11) DEFAULT
 * NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 *
 * --
 *
 *
 */
@Entity
@Data
public class Utente implements Serializable {

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    //In questo modo ogni tabella avrà il suo ID univoco che inizia con 1,2,3 ... e così via. 
    // -->>    @GeneratedValue( strategy= GenerationType.SEQUENCE, generator="native") E  @GenericGenerator( name = "native",strategy = "native")
    //Per questo motivo, su qualsiasi database che non supporta le sequenze in modo nativo (ad esempio MySQL) utilizzeremo il generatore TABLE anziché IDENTITY . meglio  SEQU3ENCE
    
    private static final long serialVersionUID = 5057388942388599430L;

    
    
    //////////////////MIGLIOR MODO DI AVERE L'AUTOINCREMENT IN MYSQL 
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id; // LONG in mysql è bigint(20) per migliaia di tuple 
    private String nome;
    private String cognome;
    private String telefono;

        ///non sono necessari perchè Lombok  genera getter e setter di campo per te..


}
