package com.cleaningegneria.Application.Service;


import com.cleaningegneria.Application.Controller.ItinerarioController;
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
    public ItinerarioService(ItinerarioRepository itinerarioRepository){
        this.itinerarioRepository = itinerarioRepository;
    }

    public String CreateItinerario(String Desc, int IdUtente){
        Itinerario Temp = new Itinerario(IdUtente, Desc);
        itinerarioRepository.save(Temp);
        return "PostSalvato";
    }

    public ArrayList<Itinerario> VisualizzaItinerari(){
        return itinerarioRepository.VisualizzaItinerari();
    }

    public Itinerario VisualizzaItinerario(int itinerarioId){
        return itinerarioRepository.VisualizzaItinerario(itinerarioId);
    }

    public String AggiungiPostAItinerario(int itineraioId, int postId){
        itinerarioRepository.aggiungiPostAItinerario(itineraioId,postId);
        return "Post aggiungto";
    }

}
