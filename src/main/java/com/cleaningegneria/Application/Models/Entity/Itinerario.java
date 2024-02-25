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
@Table(name="itinerario")
public class Itinerario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp datapubblicazione;
    @ManyToOne
    private Utente creatore;
    @ManyToMany
    private List<Post> contenuti;
    private String descrizione;

    public Itinerario(Integer idutente, String descrizione) {
        this.datapubblicazione = new Timestamp(System.currentTimeMillis());
        this.creatore = new Utente();
        this.creatore.setId(idutente);
        this.descrizione = descrizione;
    }



}
