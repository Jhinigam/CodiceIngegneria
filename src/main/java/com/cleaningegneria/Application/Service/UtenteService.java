package com.cleaningegneria.Application.Service;

import com.cleaningegneria.Application.Models.Entity.Ruolo;
import com.cleaningegneria.Application.Models.Entity.Utente;
import com.cleaningegneria.Application.Repository.UtenteRepository;

public class UtenteService {
    private UtenteRepository utenteRepository;
    private Utente User;

    public UtenteService(){

    }

    public Utente creaUtente(String nome, String cognome, String email, int eta, String ruolo, String comune){
        User = new Utente(nome,cognome,email,eta,StringToRuolo(ruolo),comune);
        return User;
    }
    public Ruolo IntToRuolo(int A){
        switch (A){
            case 0:
                return Ruolo.Contributore;
            case 1:
                return Ruolo.Turista;
            case 2:
                return Ruolo.ContributoreAutorizzato;
            case 3:
                return Ruolo.TuristaAutorizzato;
            case 4:
                return Ruolo.Curatore;
        }
        return Ruolo.Animatore;
    }
    public Ruolo StringToRuolo(String A){
        switch (A){
            case "Contributore":
                return Ruolo.Contributore;
            case "Turista":
                return Ruolo.Turista;
            case "ContributoreAutorizzato":
                return Ruolo.ContributoreAutorizzato;
            case "TuristaAutorizzato":
                return Ruolo.TuristaAutorizzato;
            case "Curatore":
                return Ruolo.Curatore;
        }
        return Ruolo.Animatore;
    }
}
