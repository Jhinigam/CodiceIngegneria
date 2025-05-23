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
public class Evento implements PostBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp datapubblicazione;
    private Timestamp dataEvento;
    @ManyToOne
    private Utente proprietario;
    @ManyToMany
    private List<Utente> partecipanti;
    private String descrizione;


    public Evento(Timestamp dataEvento, Integer idutente, String descrizione) {
        this.dataEvento = dataEvento;
        this.datapubblicazione = new Timestamp(System.currentTimeMillis());
        this.proprietario = new Utente();
        this.proprietario.setId(idutente);
        this.descrizione = descrizione;
    }
}
