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
@Table(name="itinerario")
public class Itinerario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp datapubblicazione;
    private String comune;
    @ManyToOne
    private Integer idutente;
    private String descrizione;
    private boolean pending;

    public Itinerario(Timestamp datapubblicazione, String comune, Integer idutente, String descrizione, boolean pending) {
        this.datapubblicazione = datapubblicazione;
        this.comune = comune;
        this.idutente = idutente;
        this.descrizione = descrizione;
        this.pending = pending;
    }



}
