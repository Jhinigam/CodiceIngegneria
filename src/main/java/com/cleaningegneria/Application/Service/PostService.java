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
        List<Post> Temp = new ArrayList<>();
        Post tempPost0 = new Post(-1, "Post0", true);
        Post tempPost1 = new Post(-1, "Post1", true);
        Post tempPost2 = new Post(-1, "Post2", true);
        Post tempPost3 = new Post(-1, "Post3", true);
        Temp.add(tempPost0);
        Temp.add(tempPost1);
        Temp.add(tempPost2);
        Temp.add(tempPost3);
        return Temp;
    }

    public Optional<Post> findPostById(int id){
        Optional<Post> u = postRepository.findById(id);
        return u;
    }



}
