package com.cleaningegneria.Application.Service;


import com.cleaningegneria.Application.Models.Entity.Itinerario;
import com.cleaningegneria.Application.Models.Entity.Post;
import com.cleaningegneria.Application.Repository.ItinerarioRepository;
import com.cleaningegneria.Application.Repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    public String AggiungiPostAItinerario(int idItinerario, int idPost){
        Optional<Itinerario> i = itinerarioRepository.findById(idItinerario);
        Optional<Post> p = postRepository.findById(idPost);
        i.get().AggiungiPost(p);
        itinerarioRepository.save(i.get());
        return "Post aggiunto";
    }


    public List<Post> VisualizzaPostInItinerario(int idItinerario){
        return null;
        //        return itinerarioRepository.VisualizzaPostInItinerario(idItinerario);
    }


}
