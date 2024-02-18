package com.cleaningegneria.Application.Service;

import com.cleaningegneria.Application.Models.Entity.Ruolo;
import com.cleaningegneria.Application.Models.Entity.Utente;
import com.cleaningegneria.Application.Repository.UtenteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtenteService {

    private final UtenteRepository utenteRepository;


    public UtenteService(UtenteRepository utenteRepository){
        this.utenteRepository = utenteRepository;
    }

    public Utente creaUtente(Utente User){

        utenteRepository.save(User);
        return User;
    }

    public Optional<Utente> deleteUtente(int id){
        Optional<Utente> u = utenteRepository.findById(id);
        utenteRepository.deleteById(id);
        return u;
    }

    public Optional<Utente> findUtente(int id){
        Optional<Utente> u = utenteRepository.findById(id);
        return u;
    }

    public void modificaRuoloUtente(int id, Ruolo ruolo){
        Optional<Utente> u = utenteRepository.findById(id);
        u.get().setRuolo(ruolo);
    }

}
