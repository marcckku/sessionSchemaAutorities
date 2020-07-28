package com.api.rest.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;

import java.util.List;
import lombok.Data;

@Entity
@Data
@Table(name = "AUTHORITIES")
public class Authority implements Serializable {  ////<<<<----  implements Serializable Inserito by mpavon altrimenti non serializza oggetto

    
        private static final long serialVersionUID = 5057388942388599423L;

    
        //////////////LASCIO L'ID COME DEFAULT COSI HIBERNATE CREA IL CONTATTORE PER ME!!!
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @Column(name = "NAME", length = 50)
    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthorityName name;

    @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuthorityName getName() {
        return name;
    }

    public void setName(AuthorityName name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}