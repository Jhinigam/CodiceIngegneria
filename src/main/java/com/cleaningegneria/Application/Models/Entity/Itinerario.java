package com.cleaningegneria.Application.Models.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

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
    @JoinTable(name = "itinerario_contenuti", joinColumns = @JoinColumn(name = "itinerario_id"),
                inverseJoinColumns = @JoinColumn(name = "contenuti_id"))
    private List<Post> contenuti;
    private String descrizione;

    public Itinerario(Integer idutente, String descrizione) {
        this.datapubblicazione = new Timestamp(System.currentTimeMillis());
        this.creatore = new Utente();
        this.creatore.setId(idutente);
        this.descrizione = descrizione;
    }

    public void AggiungiPost(Optional<Post> p){

        contenuti.add(p.get());
    }



}
