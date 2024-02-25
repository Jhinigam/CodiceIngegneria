package com.cleaningegneria.Application.Controller;

import com.cleaningegneria.Application.Models.DTO.CreazionePostEItinerarioDTO;
import com.cleaningegneria.Application.Models.Entity.Itinerario;
import com.cleaningegneria.Application.Models.Entity.Post;
import com.cleaningegneria.Application.Service.ItinerarioService;
import com.cleaningegneria.Application.Service.UtenteService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Itinerario")
public class ItinerarioController extends AbstractController{

    final private ItinerarioService itinerarioService;

    final private UtenteService utenteService;

    public ItinerarioController(ItinerarioService itinerarioService, UtenteService utenteService){
        this.itinerarioService = itinerarioService;
        this.utenteService = utenteService;
    }


    @CrossOrigin(origins = "http://localhost:63342")
    @PutMapping("/CreazioneItinerario")
    @ResponseBody
    public String CreazioneItinerario(@RequestBody CreazionePostEItinerarioDTO iDTO){
        System.out.println(iDTO);
        if(utenteService.CanItinerario(iDTO.getIdUtente())){
            System.out.println(itinerarioService.CreateItinerario(iDTO.getDescrizione(), iDTO.getIdUtente()));
            return "ok";
        } else return "non ok";
    }


    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/VisualizzaItinerari")
    @ResponseBody
    public ArrayList<Itinerario> VisualizzaItinerari(){
        ArrayList<Itinerario> u = itinerarioService.VisualizzaTuttiGliItinerari();
        if(u.isEmpty()){
            System.out.println("Itinerari non trovati");
            u.add(new Itinerario(-1,"0"));
            u.add(new Itinerario(-1,"1"));
            System.out.println(u);
            return u;
        }
        else {
            System.out.println("Itinerari trovati");
            System.out.println(u);
            return u;
        }
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/VisualizzaItinerario")
    @ResponseBody
    public Optional<Itinerario> VisualizzaItinerario(@RequestParam int idItinerario){
        return itinerarioService.VisualizzaItinerario(idItinerario);
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/VisualizzaPostInItinerario")
    @ResponseBody
    public List<Post> VisualizzaPostInItinerario(@RequestParam int idItinerario){
        return
    }

    /*
    @CrossOrigin(origins = "http://localhost:63342")
    @PutMapping("/VisualizzaItinerario")
    @ResponseBody
    public String AggiungiPostAItinerario(@RequestParam int idItinerario, int idPost){
        return itinerarioService.AggiungiPostAItinerario(idItinerario,idPost);
    }
    */





}
