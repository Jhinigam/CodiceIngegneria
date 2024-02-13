package com.cleaningegneria.Application.Controller;

import com.cleaningegneria.Application.Models.DTO.UtenteDTO;
import com.cleaningegneria.Application.Models.Entity.Ruolo;
import com.cleaningegneria.Application.Models.Entity.Utente;
import com.cleaningegneria.Application.Repository.UtenteRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Utente")
public class UtenteController extends AbstractController {

    /*
     @GetMapping("/contests")
    public List<Contest> searchContests(@RequestParam String name,
                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate,
                                        @RequestParam String type) {
        return searchService.searchContests(name, startDate, endDate, type);
    }
     */

    private Utente User;
    private final UtenteRepository utenteRepository;

    public UtenteController(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }



    /*
    public Utente CreateUtente(){

        User = new Utente("Nome", "Cognome", "Email", 13, IntToRuolo(1),new Comune("c", "desc"));

        //utenteRepository.save(User);
        return User;
    }*/
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
            case "Contributore Autorizzato":
                return Ruolo.ContributoreAutorizzato;
            case "Turista Autorizzato":
                return Ruolo.TuristaAutorizzato;
            case "Curatore":
                return Ruolo.Curatore;
        }
        return Ruolo.Animatore;
    }
}
