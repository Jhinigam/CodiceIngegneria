package com.cleaningegneria.Application.Controller;

import com.cleaningegneria.Application.Models.DTO.CreazionePostEItinerarioDTO;
import com.cleaningegneria.Application.Models.Entity.Itinerario;
import com.cleaningegneria.Application.Service.ItinerarioService;
import com.cleaningegneria.Application.Service.UtenteService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
    @PutMapping("/VisualizzaItinerari")
    @ResponseBody
    public ArrayList<Itinerario> VisualizzaItinerari(){
        return itinerarioService.VisualizzaItinerari();
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @PutMapping("/VisualizzaItinerario")
    @ResponseBody
    public Itinerario VisualizzaItinerario(@RequestParam int idItinerario){
        return itinerarioService.VisualizzaItinerario(idItinerario);
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @PutMapping("/VisualizzaItinerario")
    @ResponseBody
    public String AggiungiPostAItinerario(@RequestParam int idItinerario, int idPost){
        return itinerarioService.AggiungiPostAItinerario(idItinerario,idPost);
    }







}
