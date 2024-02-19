package com.cleaningegneria.Application.Service;


import com.cleaningegneria.Application.Models.Entity.Post;
import com.cleaningegneria.Application.Models.Entity.Ruolo;
import com.cleaningegneria.Application.Models.Entity.Utente;
import com.cleaningegneria.Application.Repository.PostRepository;
import com.cleaningegneria.Application.Repository.UtenteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository utenteRepository){
        this.postRepository = utenteRepository;
    }

    public String CreatePost(String Desc, int IdUtente, boolean Pending){
        Post Temp = new Post(IdUtente, Desc, Pending);
        postRepository.save(Temp);
        return "PostSalvato";
    }

    public Optional<Post> findUtente(int id){
        Optional<Post> u = postRepository.findById(id);
        return u;
    }



}
