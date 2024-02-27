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

    /**
     * salva l'utente
     * @param User
     * @return l'utente
     */
    public Utente creaUtente(Utente User){
        utenteRepository.save(User);
        return User;
    }

    /**
     * elemina l'utente tramite l'id
     * @param Id
     * @return l'utente trovato
     */
    public Optional<Utente> deleteUtente(int Id){
        Optional<Utente> u = utenteRepository.findById(Id);
        utenteRepository.eliminaPostDiUtenteById(u);
        utenteRepository.deleteById(Id);
        return u;
    }

    /**
     * trova l'utente tramite l'id
     * @param Id
     * @return l'utente trovato
     */
    public Optional<Utente> findUtente(int Id){
        return utenteRepository.findById(Id);
    }


    /**
     * modifica il ruolo dell'utente
     * @param Id,ruolo
     */
    public void modificaRuoloUtente(int Id, String ruolo){
        utenteRepository.setRuolo(ruolo,Id);
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

    /**
     * verifica se l'utente puo creare un evento
     * @param Id
     * @return true se è un animatore quindi puo crearlo altrimenti false
     */
    public boolean CanEvent(int Id){
        Optional<Utente> u = utenteRepository.findById(Id);
        switch (u.get().getRuolo().toString()){
            case "Animatore": return true;
        }
        return false;
    }

    /**
     * verifica se l'utente puo creare un post
     * @param Id
     * @return true se ha un ruolo che gli permette di creare un post altrimenti false
     */
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

    /**
     * verifica se l'utente puo creare un evento
     * @param Id
     * @return true se ha un ruolo che gli permette di creare un evento altrimenti false
     */
    public boolean CanItinerario(int Id){
        Optional<Utente> u = utenteRepository.findById(Id);
        switch (u.get().getRuolo().toString()){
            case "ContributoreAutorizzato": return true;
            case "Curatore": return true;
        }
        return false;
    }

    /**
     * visualizziamo tutti i post appartenenti a un comune specifico
     * @param Comune
     * @return la lista di tutti i post appartententi a quel comune
     */
    public ArrayList<Post> visualizzaPostComune(String Comune){
        return utenteRepository.selezionaPostDiComune(Comune);
    }

    /**
     * visualizziamo tutti i post appartenenti a un utente specifico
     * @param idUtente
     * @return la lista di tutti i post appartententi a quel utente
     */
    public List<Post> VisualizzaPostDiUnUtente(int idUtente){
        System.out.println("Entrato in service: ");
        Optional<Utente> u = findUtente(idUtente);
        System.out.println(u);
        return utenteRepository.selezionaPostDiUtenteById(u);
    }

}
