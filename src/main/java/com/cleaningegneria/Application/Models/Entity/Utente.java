package com.cleaningegneria.Application.Models.Entity;

import com.cleaningegneria.Application.Models.DTO.CreazioneUtenteDTO;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name="utente")
public class Utente {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cognome;
    private String email;
    private String comune;
    /**
     * Contributore = 0
     * Turista = 1
     * ContributoreAutorizzato = 2
     * TuristaAutorizzato = 3
     * Curatore = 4
     * Animatore = 5
     */
    private String ruolo;
    private int Eta;


    public Utente(CreazioneUtenteDTO uDTO){
        this.id = 0;
        this.nome = uDTO.getNome();
        this.cognome = uDTO.getCognome();
        this.email = uDTO.getEmail();
        this.Eta = uDTO.getEta();
        this.ruolo = uDTO.getRuolo();
        this.comune = uDTO.getComune();
    }

}
