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

    // Metodo per gestire la creazione di un nuovo evento.
    @CrossOrigin(origins = "http://localhost:63342")
    @PutMapping("/CreazioneEvento")
    @ResponseBody
    public String CreaEvento(@RequestBody CreazioneEventoDTO eDTO) {
        if(utenteService.CanEvent(eDTO.getIdUtente())){              // Verifica se l'utente è autorizzato a creare un evento.
            System.out.println(eventoService.CreateEvento(eDTO.getDescrizione(), eDTO.getIdUtente(), eDTO.getDataEvento()));    // Creazione dell'evento utilizzando il servizio EventoService.
            return "Evento creato";
        }
        else {
            return "Utente Non Idoneo";     // Messaggio di errore nel caso in cui l'utente non sia autorizzato.
        }
    }

    // Metodo per visualizzare un evento specifico.
    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/VisualizzaEvento")
    @ResponseBody
    public Optional<Evento> visualizzaEvento(@RequestParam int idEvento){
        Optional u = eventoService.findEventoById(idEvento);        // Ricerca dell'evento tramite il servizio EventoService.
        if(u.equals(Optional.empty())){
            System.out.println("Evento non trovato");
            Evento ut = new Evento(null,-1,"");  // Se l'evento non viene trovato, viene restituito un evento vuoto con un ID negativo.
            return Optional.of(ut);
        }
        else {
            System.out.println("Evento trovato");       // Se l'evento viene trovato, viene restituito l'evento trovato.
            return u;
        }
    }








}
