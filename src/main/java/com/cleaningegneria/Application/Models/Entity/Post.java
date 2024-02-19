package com.cleaningegneria.Application.Models.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp datapubblicazione;
    @ManyToOne
    private Utente utente;
    private String descrizione;
    private boolean pending;


    public Post( Integer idutente, String descrizione, boolean pending) {
        this.datapubblicazione = new Timestamp(System.currentTimeMillis());
        this.utente = new Utente();
        this.utente.setId(idutente);
        this.descrizione = descrizione;
        this.pending = pending;
    }



}


