package com.cleaningegneria.Application.Models.Entity;

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
@Table(name="utente")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String Nome;
    private String Cognome;
    private String Email;
    private String Comune;
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
     * @param comune String
     */
    public Utente(String Nome, String Cognome, String Email, int Eta, Ruolo ruolo, String comune){
        this.Nome = Nome;
        this.Cognome = Cognome;
        this.Email = Email;
        this.Eta = Eta;
        this.ruolo = ruolo;
        this.Comune = comune;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }
}
