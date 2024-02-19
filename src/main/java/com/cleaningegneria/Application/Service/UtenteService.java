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


    public void modificaRuoloUtente(int id, String ruolo){
        utenteRepository.setRuolo(ruolo,id);
    }

    /**
     * verifica se l'utente posta o mette in pending
     * @param Id
     * @return true, se posta, false se è pending
     */
    public boolean UserPending(int Id){
        Optional<Utente> u = utenteRepository.findById(Id);
        switch (u.get().getRuolo().toString()){
            case "ContributoreAutorizzato": return true;
            case "Animatore": return true;
            case "Curatore": return true;
        }
        return false;
    }
}
