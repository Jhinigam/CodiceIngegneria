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
    public Ruolo IntToRuolo(int A){
        return switch (A) {
            case 0 -> Ruolo.Contributore;
            case 1 -> Ruolo.Turista;
            case 2 -> Ruolo.ContributoreAutorizzato;
            case 3 -> Ruolo.TuristaAutorizzato;
            case 4 -> Ruolo.Curatore;
            default -> Ruolo.Animatore;
        };
    }
    public Ruolo StringToRuolo(String A){
        return switch (A) {
            case "Contributore" -> Ruolo.Contributore;
            case "Turista" -> Ruolo.Turista;
            case "ContributoreAutorizzato" -> Ruolo.ContributoreAutorizzato;
            case "TuristaAutorizzato" -> Ruolo.TuristaAutorizzato;
            case "Curatore" -> Ruolo.Curatore;
            default -> Ruolo.Animatore;
        };
    }


}
