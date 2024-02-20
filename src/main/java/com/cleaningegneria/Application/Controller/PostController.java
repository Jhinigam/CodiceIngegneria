package com.cleaningegneria.Application.Controller;


import com.cleaningegneria.Application.Models.DTO.CreazionePostBaseDTO;
import com.cleaningegneria.Application.Models.Entity.*;
import com.cleaningegneria.Application.Service.PostService;
import com.cleaningegneria.Application.Service.UtenteService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Post")
public class PostController extends AbstractController{

    private final PostService postService;

    private final UtenteService utenteService;

    public PostController(PostService postService, UtenteService utenteService) {
        this.postService = postService;
        this.utenteService = utenteService;
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @PutMapping("/CreazionePostBase")
    @ResponseBody
    public String CreaPostBase(@RequestBody CreazionePostBaseDTO pDTO){
        if(utenteService.CanPost(pDTO.getIdUtente())){
            System.out.println(postService.CreatePost(pDTO.getDescrizione(), pDTO.getIdUtente(), utenteService.UserPending(pDTO.getIdUtente())));
            return "ok";
        } else return "non ok";
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/VisualizzaPost")
    @ResponseBody
    public Optional<Post> visualizzaPost(@RequestParam int idPost){
        Optional u = postService.findPostById(idPost);
        if(u.equals(Optional.empty())){
            System.out.println("Post non trovato");
            Post ut = new Post(-1,"",false);
            return Optional.of(ut);
        }
        else {
            System.out.println("Post trovato");
            return u;
        }
    }


}
