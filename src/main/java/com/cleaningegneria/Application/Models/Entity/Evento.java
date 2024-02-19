package com.cleaningegneria.Application.Models.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

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
    private Utente creatore;
    @ManyToMany
    private List<Utente> partecipanti;
    private String descrizione;


    public Evento(Timestamp datapubblicazione, Timestamp datainizio, Timestamp datafine, String comune, Integer idutente, String descrizione) {
        this.datapubblicazione = datapubblicazione;
        this.datainizio = datainizio;
        this.datafine = datafine;
        this.creatore = new Utente();
        this.creatore.setId(idutente);
        this.descrizione = descrizione;
    }
}
