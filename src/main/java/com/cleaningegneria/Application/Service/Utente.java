package com.cleaningegneria.Application.Service;

import java.util.List;


public class Utente {
    private Integer id;
    private String Nome;
    private String Cognome;
    private String Email;
    private List<Integer> PostSalvati;
    private int Eta;
    private Ruolo ruolo;

    /**
     * Costruttore Utente
     * @param Nome String
     * @param Cognome String
     * @param Email String
     * @param Eta Int
     * @param ruolo se il ruolo è 0 o 1, l'utente non è autorizzato
     */
    public Utente(String Nome, String Cognome, String Email, int Eta, Ruolo ruolo){
        this.Nome = Nome;
        this.Cognome = Cognome;
        this.Email = Email;
        this.Eta = Eta;
        this.ruolo = ruolo;
    }

    public String getNome() {
        return Nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public String getEmail() {
        return Email;
    }
    public int getEta(){
        return Eta;
    }

    public String getRuolo() {
        return ruolo.toString();
    }
}
