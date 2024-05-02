package com.cleaningegneria.Application.Service;


import com.cleaningegneria.Application.Models.Entity.CreatorePost;
import com.cleaningegneria.Application.Models.Entity.Post;
import com.cleaningegneria.Application.Repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;


    public PostService(PostRepository utenteRepository){
        this.postRepository = utenteRepository;
    }

    /**
     * crea il post
     * @param Desc,IdUtente,Pending
     * @return la stringa "PostSalvato" se il post è stato creato correttamente
     */
    public String CreaPost(String Desc, int IdUtente, boolean Pending){
        CreatorePost Temp = new CreatorePost(Pending);
        postRepository.save((Post)Temp.CreaPost(IdUtente, Desc));
        return "PostSalvato";
    }

    /**
     * visualizziamo tutti i post in pending
     * @return la lista di tutti i post in pending
     */
    public List<Post> VisualizzaPostInPending(){
        return postRepository.VisualizzaPostPending();
    }

    /**
     * trova un post tramite il suo id
     * @param Id
     * @return il post che ha quel id
     */
    public Optional<Post> TrovaPostDalID(int Id){
        Optional<Post> u = postRepository.findById(Id);
        return u;
    }



}
