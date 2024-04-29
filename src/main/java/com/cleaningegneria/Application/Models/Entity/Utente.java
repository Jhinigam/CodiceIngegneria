package com.cleaningegneria.Application.Models.Entity;

import com.cleaningegneria.Application.Models.DTO.CreazioneUtenteDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    private String Nome;
    private String Cognome;
    private String Email;
    private String Comune;
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
        this.Nome = uDTO.getNome();
        this.Cognome = uDTO.getCognome();
        this.Email = uDTO.getEmail();
        this.Eta = uDTO.getEta();
        this.ruolo = uDTO.getRuolo();
        this.Comune = uDTO.getComune();
    }

}
