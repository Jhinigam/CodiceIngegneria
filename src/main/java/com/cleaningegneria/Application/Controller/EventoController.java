package com.cleaningegneria.Application.Controller;


import com.cleaningegneria.Application.Models.DTO.CreazioneEventoDTO;
import com.cleaningegneria.Application.Models.Entity.Evento;
import com.cleaningegneria.Application.Service.EventoService;
import com.cleaningegneria.Application.Service.UtenteService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Evento")
public class EventoController extends AbstractController {

    private final EventoService eventoService;

    private final UtenteService utenteService;

    public EventoController(EventoService eventoService, UtenteService utenteService) {
        this.eventoService = eventoService;
        this.utenteService = utenteService;
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @PutMapping("/CreazioneEvento")
    @ResponseBody
    public String CreaEvento(@RequestBody CreazioneEventoDTO eDTO) {
        if(utenteService.CanEvent(eDTO.getIdUtente())){
            System.out.println(eventoService.CreaEvento(eDTO.getDescrizione(), eDTO.getIdUtente(), eDTO.getDataEvento()));
            return "Evento creato";
        } else return "Utente Non Idoneo";
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/VisualizzaEvento")
    @ResponseBody
    public Optional<Evento> visualizzaEvento(@RequestParam int idEvento){
        Optional u = eventoService.TrovaEventoDalID(idEvento);
        if(u.equals(Optional.empty())){
            System.out.println("Evento non trovato");
            Evento ut = new Evento(null,-1,"");
            return Optional.of(ut);
        }
        else {
            System.out.println("Evento trovato");
            return u;
        }
    }








}
