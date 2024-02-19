package com.cleaningegneria.Application.Controller;


import com.cleaningegneria.Application.Models.DTO.CreazioneEventoDTO;
import com.cleaningegneria.Application.Models.DTO.CreazionePostBaseDTO;
import com.cleaningegneria.Application.Models.Entity.Evento;
import com.cleaningegneria.Application.Models.Entity.Post;
import com.cleaningegneria.Application.Service.EventoService;
import com.cleaningegneria.Application.Service.PostService;
import com.cleaningegneria.Application.Service.UtenteService;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
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
    public void CreaEvento(@RequestBody CreazioneEventoDTO eDTO) {
        System.out.println(eventoService.CreateEvento(eDTO.getDescrizione(), eDTO.getIdUtente(), utenteService.UserPending(eDTO.getIdUtente()), eDTO.getDataInizio(), eDTO.getDataFine()));
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/VisualizzaEvento")
    @ResponseBody
    public Optional<Evento> visualizzaEvento(@RequestParam int idEvento){
        Optional u = eventoService.findUtente(idEvento);
        if(u.equals(Optional.empty())){
            System.out.println("Evento non trovato");
            Evento ut = new Evento(null,null,-1,"");
            return Optional.of(ut);
        }
        else {
            System.out.println("Evento trovato");
            return u;
        }
    }








}
