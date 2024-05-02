package com.cleaningegneria.Application.Controller;

import com.cleaningegneria.Application.Models.DTO.AggiungiPostAItinerarioDTO;
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

    // Metodo per gestire la creazione di un nuovo itinerario.
    @CrossOrigin(origins = "http://localhost:63342")
    @PutMapping("/CreazioneItinerario")
    @ResponseBody
    public String CreazioneItinerario(@RequestBody CreazionePostEItinerarioDTO iDTO){
        System.out.println(iDTO);
        if(utenteService.CanItinerario(iDTO.getIdUtente())){    // Verifica se l'utente è autorizzato a creare un itinerario.
            System.out.println(itinerarioService.CreateItinerario(iDTO.getDescrizione(), iDTO.getIdUtente()));  // Creazione dell'itinerario utilizzando itinerarioService.
            return "ok";
        } else{
            return "non ok";    // Messaggio di errore nel caso in cui l'utente non sia autorizzato.
        }
    }

    // Metodo per visualizzare tutti gli itinerari disponibili.
    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/VisualizzaItinerari")
    @ResponseBody
    public ArrayList<Itinerario> VisualizzaItinerari(){
        ArrayList<Itinerario> u = itinerarioService.VisualizzaTuttiGliItinerari();  // Ottiene tutti gli itinerari utilizzando itinerarioService.
        if(u.isEmpty()){    // Se non vengono trovati itinerari, vengono restituiti due itinerari vuoti con ID negativo.
            System.out.println("Itinerari non trovati");
            u.add(new Itinerario(-1,"0"));
            u.add(new Itinerario(-1,"1"));
            System.out.println(u);
            return u;
        }
        else {  // Se vengono trovati degli itinerari, vengono restituiti.
            System.out.println("Itinerari trovati");
            System.out.println(u);
            return u;
        }
    }

    // Metodo per visualizzare un itinerario specifico.
    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/VisualizzaItinerario")
    @ResponseBody
    public Optional<Itinerario> VisualizzaItinerario(@RequestParam int idItinerario){
        return itinerarioService.VisualizzaItinerario(idItinerario); // Ottiene l'itinerario specifico utilizzando itinerarioService.
    }


    // Metodo per aggiungere un post a un itinerario.
    @CrossOrigin(origins = "http://localhost:63342")
    @PutMapping("/AggiungiPostAItinerario")
    @ResponseBody
    public String AggiungiPostAItinerario(@RequestBody AggiungiPostAItinerarioDTO dto){
        return itinerarioService.AggiungiPostAItinerario(dto.getIdItinerario(),dto.getIdPost());    // Utilizza itinerarioService per aggiungere un post a un itinerario.
    }

    // Metodo per visualizzare i post in un itinerario specifico.
    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/VisualizzaPostInItinerario")
    @ResponseBody
    public List<Post> VisualizzaPostInUnItinerario(@RequestParam int idItinerario){
        return itinerarioService.VisualizzaPostInItinerario(idItinerario);  // Ottiene i post in un itinerario specifico utilizzando itinerarioService.
    }






}
