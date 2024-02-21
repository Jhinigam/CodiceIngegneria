package com.cleaningegneria.Application.Service;


import com.cleaningegneria.Application.Models.Entity.Post;
import com.cleaningegneria.Application.Repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public List<Post> VisualizzaPostInPending(){
        return postRepository.VisualizzaPostPending();
    }

    public Optional<Post> findPostById(int id){
        Optional<Post> u = postRepository.findById(id);
        return u;
    }



}
