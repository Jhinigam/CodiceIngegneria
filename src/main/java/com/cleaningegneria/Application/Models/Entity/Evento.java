package com.cleaningegneria.Application.Models.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name="evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp datapubblicazione;
    private Timestamp datainizio;
    private Timestamp datafine;
    @ManyToOne
    private Utente utente;
    private String descrizione;


    public Evento(Timestamp datainizio, Timestamp datafine, Integer idutente, String descrizione) {
        this.datainizio = datainizio;
        this.datafine = datafine;
        this.utente = new Utente();
        this.utente.setId(idutente);
        this.descrizione = descrizione;
    }
}
