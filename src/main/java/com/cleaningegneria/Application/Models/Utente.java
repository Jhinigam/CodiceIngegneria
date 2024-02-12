package com.cleaningegneria.Application.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name="Utente")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String Nome;
    private String Cognome;
    private String Email;
    @ManyToOne
    private Comune Comune;
    @OneToMany()
    private List<Post> PostSalvati;
    private Ruolo ruolo;
    private int Eta;


    /**
     * Costruttore Utente
     * @param Nome String
     * @param Cognome String
     * @param Email String
     * @param Eta Int
     * @param ruolo se il ruolo è 0 o 1, l'utente non è autorizzato
     * @param comune Comune
     */
    public Utente(String Nome, String Cognome, String Email, int Eta, Ruolo ruolo, Comune comune){
        this.Nome = Nome;
        this.Cognome = Cognome;
        this.Email = Email;
        this.Eta = Eta;
        this.ruolo = ruolo;
        this.Comune = comune;
    }

}
