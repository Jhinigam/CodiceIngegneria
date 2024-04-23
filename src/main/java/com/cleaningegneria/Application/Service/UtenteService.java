package com.cleaningegneria.Application.Service;

import com.cleaningegneria.Application.Models.Entity.Itinerario;
import com.cleaningegneria.Application.Models.Entity.Post;
import com.cleaningegneria.Application.Models.Entity.Utente;
import com.cleaningegneria.Application.Repository.ItinerarioRepository;
import com.cleaningegneria.Application.Repository.UtenteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    private final UtenteRepository utenteRepository;
    private final ItinerarioRepository itinerarioRepository;


    public UtenteService(UtenteRepository utenteRepository, ItinerarioRepository itinerarioRepository){
        this.utenteRepository = utenteRepository;
        this.itinerarioRepository = itinerarioRepository;
    }

    /**
     * Crea un Utente
     * @param User
     * @return l'utente creato
     */
    public Utente CreaUtente(Utente User){
        utenteRepository.save(User);
        return User;
    }

    /**
     * Elimina un Utente tramite il suo Id
     * @param Id
     * @return l'utente eliminato
     */
    public Optional<Utente> EliminaUtente(int Id){
        Optional<Utente> u = utenteRepository.findById(Id);
        if(u.equals(Optional.empty())){
            return u;
        }
        ArrayList<Itinerario> iList = (ArrayList<Itinerario>) itinerarioRepository.findAll();     //lista di tutti gli itinerari
        ArrayList<Post> pList = utenteRepository.selezionaPostDiUtenteById(u.get());              //Lista di tutti i post dell'utente con id passato
        for(Itinerario i: iList){
            for(Post p: pList){
                if(i.getContenuti().contains(p)){
                    i.getContenuti().remove(p);                     //Rimuove da ogni itinerario i post dell'utente che sta per venir eliminato
                    itinerarioRepository.save(i);
                }
            }
        }

        utenteRepository.eliminaPostDiUtenteById(u);            //Elimino dal DB prima tutti gli itinerari e i post dell'utente
        utenteRepository.eliminaItinerariDiUtenteById(u);
        utenteRepository.deleteById(Id);
        return u;
    }

    /**
     * Trova un Utente tramite il suo Id
     * @param Id
     * @return l'utente trovato
     */
    public Optional<Utente> TrovaUtenteDalID(int Id){
        return utenteRepository.findById(Id);
    }

    /**
     * Modifica il ruolo di un Utente tramite il suo Id
     * @param Id
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
     * Controlla se l'utente può postare un evento
     * @param Id
     * @return true se puà, false altrimenti
     */
    public boolean CanEvent(int Id){
        Optional<Utente> u = utenteRepository.findById(Id);
        switch (u.get().getRuolo().toString()){
            case "Animatore": return true;
        }
        return false;
    }

    /**
     * Controlla se l'utente può postare un post
     * @param Id
     * @return true se puà, false altrimenti
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
     * Controlla se l'utente può postare un itinerario
     * @param Id
     * @return true se puà, false altrimenti
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
        Optional<Utente> u = TrovaUtenteDalID(idUtente);
        System.out.println(u);
        return utenteRepository.selezionaPostDiUtenteById(u.get());
    }

}
