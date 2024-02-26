package com.cleaningegneria.Application.Service;


import com.cleaningegneria.Application.Models.Entity.Itinerario;
import com.cleaningegneria.Application.Models.Entity.Post;
import com.cleaningegneria.Application.Repository.ItinerarioRepository;
import com.cleaningegneria.Application.Repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ItinerarioService {

    final private ItinerarioRepository itinerarioRepository;
    final private PostRepository postRepository;
    public ItinerarioService(ItinerarioRepository itinerarioRepository, PostRepository postRepository){
        this.itinerarioRepository = itinerarioRepository;
        this.postRepository = postRepository;
    }

    public String CreateItinerario(String Desc, int IdUtente){
        Itinerario Temp = new Itinerario(IdUtente, Desc);
        itinerarioRepository.save(Temp);
        return "PostSalvato";
    }

    public ArrayList<Itinerario> VisualizzaTuttiGliItinerari(){
        ArrayList<Itinerario> u = (ArrayList<Itinerario>) itinerarioRepository.findAll();
        return u;
    }

    public Optional<Itinerario> VisualizzaItinerario(int idItinerario){
        return itinerarioRepository.findById(idItinerario);
    }

    public String AggiungiPostAItinerario(int itinerarioId, int postId){
        Optional<Itinerario> i = itinerarioRepository.findById(Integer.valueOf(itinerarioId));
        if(i.isEmpty()) return "Itinerario non trovato";
        Optional<Post> p = postRepository.findById(Integer.valueOf(postId));
        if(p.isEmpty()) return "Post non trovato";
        if(i.get().getContenuti().contains(p)) return "Post già presente in itinerario";
        i.get().AggiungiPost(p);
        itinerarioRepository.save(i.get());

        return "Post aggiunto";
    }

}
