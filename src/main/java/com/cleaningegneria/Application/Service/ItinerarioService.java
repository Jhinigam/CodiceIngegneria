package com.cleaningegneria.Application.Service;


import com.cleaningegneria.Application.Models.Entity.Itinerario;
import com.cleaningegneria.Application.Models.Entity.Post;
import com.cleaningegneria.Application.Repository.ItinerarioRepository;
import com.cleaningegneria.Application.Repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItinerarioService {

    final private ItinerarioRepository itinerarioRepository;
    final private PostRepository postRepository;
    public ItinerarioService(ItinerarioRepository itinerarioRepository, PostRepository postRepository){
        this.itinerarioRepository = itinerarioRepository;
        this.postRepository = postRepository;
    }

    /**
     * Crea l'itinerario
     * @param Desc,IdUtente
     * @return la stringa "ItinerarioSalvato" se l'itinerario è stato creato correttamente
     */
    public String CreaItinerario(String Desc, int IdUtente){
        Itinerario Temp = new Itinerario(IdUtente, Desc);
        itinerarioRepository.save(Temp);
        return "ItinerarioSalvato";
    }

    /**
     * Visualizziamo tutti gli itinerari
     * @return la lista di tutti gli itinerari
     */
    public ArrayList<Itinerario> VisualizzaTuttiGliItinerari(){
        ArrayList<Itinerario> u = (ArrayList<Itinerario>) itinerarioRepository.findAll();
        return u;
    }

    /**
     * Trova un itinerario tramite il suo id
     * @param idItinerario
     * @return l'itinerario che ha quel id
     */
    public Optional<Itinerario> VisualizzaItinerario(int idItinerario){
        return itinerarioRepository.findById(idItinerario);
    }

    /**
     * Aggiunge un determinato post a un determinato itinerario
     * @param idItinerario,idPost
     * @return la stringa "Post aggiunto" se il post è stato aggiunto correttamente all'itinerario
     */
    public String AggiungiPostAItinerario(int idItinerario, int idPost){
        Optional<Itinerario> i = itinerarioRepository.findById(idItinerario);
        Optional<Post> p = postRepository.findById(idPost);
        i.get().AggiungiPost(p);
        itinerarioRepository.save(i.get());
        return "Post aggiunto";
    }

    /**
     * Visualizziamo tutti i post che appartengono a un determinato itinerario
     * @param idItinerario
     * @return la lista di tutti i post che appartengono all'itinerario
     */
    public List<Post> VisualizzaPostInItinerario(int idItinerario){
        Optional<Itinerario> i = itinerarioRepository.findById(idItinerario);
        return i.get().getContenuti();
    }


}
