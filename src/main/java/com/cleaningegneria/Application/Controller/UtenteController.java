package com.cleaningegneria.Application.Controller;

import com.cleaningegneria.Application.Models.DTO.ModificaRuoloDTO;
import com.cleaningegneria.Application.Models.DTO.CreazioneUtenteDTO;
import com.cleaningegneria.Application.Models.Entity.Utente;
import com.cleaningegneria.Application.Service.UtenteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Utente")
public class UtenteController extends AbstractController {

    private UtenteService utenteService;
    private Utente User;
    public UtenteController() {
        utenteService = new UtenteService();

    }


    @CrossOrigin(origins = "http://localhost:63342")
    @PutMapping("/MRuolo")
    @ResponseBody
    public String CambioRuolo(@RequestBody ModificaRuoloDTO uDTO){
        //User.setRuolo(StringToRuolo(uDTO.getNewRuolo()));
        return "ok";
    }

    @CrossOrigin(origins = "http://localhost:63342/")
    @PutMapping("/Creazione")
    @ResponseBody
    public Utente CreateUtente(@RequestBody CreazioneUtenteDTO uDTO){
        return utenteService.creaUtente(uDTO.getNome(),uDTO.getCognome(), uDTO.getEmail(), uDTO.getEta(), uDTO.getRuolo(), uDTO.getComune());

    }



    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/DatiUtente")
    @ResponseBody
    public Utente VisualizzaDatiUtenteTest(){
        return User;
    }



}
