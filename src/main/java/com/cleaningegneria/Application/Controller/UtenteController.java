package com.cleaningegneria.Application.Controller;

import com.cleaningegneria.Application.Models.DTO.ModificaRuoloDTO;
import com.cleaningegneria.Application.Models.DTO.UtenteDTO;
import com.cleaningegneria.Application.Models.Entity.Ruolo;
import com.cleaningegneria.Application.Models.Entity.Utente;
import com.cleaningegneria.Application.Repository.UtenteRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Utente")
public class UtenteController extends AbstractController {

    private Utente User;
    private final UtenteRepository utenteRepository;

    public UtenteController(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }



    @CrossOrigin(origins = "http://localhost:63342")
    @PutMapping("/MRuolo")
    @ResponseBody
    public String CambioRuolo(@RequestBody ModificaRuoloDTO uDTO){
        User.setRuolo(StringToRuolo(uDTO.getNewRuolo()));
        return "ok";
    }

    @CrossOrigin(origins = "http://localhost:63342/")
    @PutMapping("/Creazione")
    @ResponseBody
    public String CreateUtente(@RequestBody UtenteDTO uDTO){

        User = new Utente(uDTO.getNome(),
                uDTO.getCognome(),
                uDTO.getEmail(),
                uDTO.getEta(),
                StringToRuolo(uDTO.getRuolo()),
                uDTO.getComune());

        return "ok";
    }



    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/DatiUtente")
    @ResponseBody
    public Utente VisualizzaDatiUtenteTest(){
        return User;
    }


    public Ruolo IntToRuolo(int A){
        switch (A){
            case 0:
                return Ruolo.Contributore;
            case 1:
                return Ruolo.Turista;
            case 2:
                return Ruolo.ContributoreAutorizzato;
            case 3:
                return Ruolo.TuristaAutorizzato;
            case 4:
                return Ruolo.Curatore;
        }
        return Ruolo.Animatore;
    }
    public Ruolo StringToRuolo(String A){
        switch (A){
            case "Contributore":
                return Ruolo.Contributore;
            case "Turista":
                return Ruolo.Turista;
            case "ContributoreAutorizzato":
                return Ruolo.ContributoreAutorizzato;
            case "TuristaAutorizzato":
                return Ruolo.TuristaAutorizzato;
            case "Curatore":
                return Ruolo.Curatore;
        }
        return Ruolo.Animatore;
    }
}
