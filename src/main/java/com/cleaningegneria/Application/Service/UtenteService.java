package com.cleaningegneria.Application.Service;

import com.cleaningegneria.Application.Models.Entity.Post;
import com.cleaningegneria.Application.Models.Entity.Utente;
import com.cleaningegneria.Application.Repository.UtenteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
        utenteRepository.eliminaPostDiUtenteById(u);
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

    public void gestisciPending(int idPost){
        utenteRepository.GestionePending(idPost);
        System.out.println("Pending Gestito Con Successo");
    }

    /**
     * verifica se l'utente posta o mette in pending
     * @param Id
     * @return false, se posta, true se è pending
     */
    public boolean UserPending(int Id){
        Optional<Utente> u = utenteRepository.findById(Id);
        switch (u.get().getRuolo().toString()){
            case "ContributoreAutorizzato": return false;
            case "Animatore": return false;
            case "Curatore": return false;
        }
        return true;
    }

    public boolean CanEvent(int Id){
        Optional<Utente> u = utenteRepository.findById(Id);
        switch (u.get().getRuolo().toString()){
            case "Animatore": return true;
        }
        return false;
    }
    public boolean CanPost(int Id){
        Optional<Utente> u = utenteRepository.findById(Id);
        switch (u.get().getRuolo().toString()){
            case "Contributore": return true;
            case "ContributoreAutorizzato": return true;
            case "Animatore": return true;
            case "Curatore": return true;
        }
        return false;
    }

    public ArrayList<Post> visualizzaPostUtente(int Id){
        Optional<Utente> u = utenteRepository.findById(Id);
        return utenteRepository.selezionaPostDiUtenteById(u);
    }

    public ArrayList<Post> visualizzaPostComune(String Comune){
        return utenteRepository.selezionaPostDiComune(Comune);
    }

    public List<Post> VisualizzaPostDiUnUtente(int idUtente){
        Optional<Utente> u = findUtente(idUtente);
        return utenteRepository.selezionaPostDiUtenteById(u);
    }

}
