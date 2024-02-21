package com.cleaningegneria.Application.Controller;


import com.cleaningegneria.Application.Models.DTO.CreazionePostBaseDTO;
import com.cleaningegneria.Application.Models.Entity.*;
import com.cleaningegneria.Application.Service.PostService;
import com.cleaningegneria.Application.Service.UtenteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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


    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/VisualizzaPending")
    @ResponseBody
    public List<Post> visualizzaPending(){
        List<Post> u = postService.VisualizzaPostInPending();
        if(u.isEmpty()){
            System.out.println("Post non trovati");
            u.add(new Post(-1,"",false));
            System.out.println(u);
            return u;
        }
        else {
            System.out.println("Post trovati");
            System.out.println(u);
            return u;
        }
    }

    @GetMapping("/VisualizzaPostDiUnUtente")
    @ResponseBody
    public List<Post> VisualizzaPostDiUnUtente(@RequestParam int IdUtente){
        List<Post> u = utenteService.VisualizzaPostDiUnUtente(IdUtente);
        if(u.isEmpty()){
            System.out.println("Post non trovati");
            u.add(new Post(-1,"",false));
            System.out.println(u);
            return u;
        }
        else {
            System.out.println("Post trovati");
            System.out.println(u);
            return u;
        }
    }

    @GetMapping("/VisualizzaPostDiUnComune")
    @ResponseBody
    public List<Post> VisualizzaPostDiUnComune(@RequestParam String Comune){
        List<Post> u = utenteService.visualizzaPostComune(Comune);
        if(u.isEmpty()){
            System.out.println("Post non trovati");
            u.add(new Post(-1,"",false));
            System.out.println(u);
            return u;
        }
        else {
            System.out.println("Post trovati");
            System.out.println(u);
            return u;
        }
    }




}
