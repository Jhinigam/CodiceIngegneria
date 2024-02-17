package com.cleaningegneria.Application.Service;

import com.cleaningegneria.Application.Models.Entity.Ruolo;
import com.cleaningegneria.Application.Models.Entity.Utente;
import com.cleaningegneria.Application.Repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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

}
