package com.cleaningegneria.Application.Controller;

import com.cleaningegneria.Application.Models.DTO.ModificaRuoloDTO;
import com.cleaningegneria.Application.Models.DTO.CreazioneUtenteDTO;
import com.cleaningegneria.Application.Models.Entity.Utente;
import com.cleaningegneria.Application.Service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import java.io.Console;

@RestController
@RequestMapping("/Utente")
public class UtenteController extends AbstractController {


    private UtenteService utenteService;
    public UtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;

    }

    @CrossOrigin(origins = "http://localhost:63342")
    @PutMapping("/ModificaRuolo")
    @ResponseBody
    public String CambioRuolo(@RequestBody ModificaRuoloDTO uDTO){
        Optional<Utente> u = utenteService.findUtente(uDTO.getId());
        if(u.equals(Optional.empty())){
            System.out.println("Utente non trovato");
            return ("Utente non trovato");
        }
        else {
            utenteService.modificaRuoloUtente(uDTO.getId(),uDTO.getNewRuolo());
            return "Utente modificato con successo";
        }
    }

    @CrossOrigin(origins = "http://localhost:63342/")
    @PutMapping("/Creazione")
    @ResponseBody
    public Utente CreateUtente(@RequestBody CreazioneUtenteDTO uDTO){
        return utenteService.creaUtente(new Utente(uDTO));
    }
    @GetMapping("/Cancella")
    @ResponseBody
    public String DeleteUtente(@RequestParam int idUtente){
        Optional<Utente> u = utenteService.deleteUtente(idUtente);
        if(u.equals(Optional.empty())){
            System.out.println("Utente non trovato");
            return ("Utente non trovato");
        }
        else {
            System.out.println("Utente con id "+ u.get().getId().toString() + " cancellato con successo!");
            return "Utente con id "+ u.get().getId().toString() + " cancellato con successo!";
        }
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/VisualizzaUtente")
    @ResponseBody
    public Optional<Utente> VisualizzaDatiUtenteTest(@RequestParam int idUtente){
        Optional<Utente> u = utenteService.findUtente(idUtente);
        if(u.equals(Optional.empty())){
            System.out.println("Utente non trovato");
            throw new NullPointerException();
        }
        else {
            System.out.println("Utente trovato");
            return u;
        }
    }



}
