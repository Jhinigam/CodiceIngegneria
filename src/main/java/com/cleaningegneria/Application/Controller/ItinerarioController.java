package com.cleaningegneria.Application.Controller;

import com.cleaningegneria.Application.Models.DTO.CreazionePostEItinerarioDTO;
import com.cleaningegneria.Application.Service.ItinerarioService;
import com.cleaningegneria.Application.Service.UtenteService;
import org.springframework.web.bind.annotation.*;

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
}
