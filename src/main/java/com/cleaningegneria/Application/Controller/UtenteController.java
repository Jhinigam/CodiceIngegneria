package com.cleaningegneria.Application.Controller;

import com.cleaningegneria.Application.Models.Comune;
import com.cleaningegneria.Application.Models.Ruolo;
import com.cleaningegneria.Application.Models.Utente;
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

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/Creazione")
    @ResponseBody
    public Utente CreateUtente(){

        User = new Utente("Nome", "Cognome", "Email", 13, IntToRuolo(1),new Comune("c", "desc"));

        //utenteRepository.save(User);
        return User;
    }/*
    public Utente CreateUtente(@RequestParam String Nome,
                               @RequestParam String Cognome,
                               @RequestParam String Email,
                               @RequestParam Comune Comune,
                               @RequestParam int ruolo,
                               @RequestParam Integer Eta){

        User = new Utente(Nome, Cognome, Email, Eta, IntToRuolo(ruolo),Comune);
        return User;
    }
*/
    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/Dati")
    @ResponseBody
    public String DettagliUtente(){
        String Result = User.getNome() + User.getCognome() + User.getEmail() + User.getRuolo() + User.getEta();
        return Result;
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
        return null;
    }

}
