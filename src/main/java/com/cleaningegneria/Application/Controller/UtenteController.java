package com.cleaningegneria.Application.Controller;

import com.cleaningegneria.Application.Service.Ruolo;
import com.cleaningegneria.Application.Service.Utente;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
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

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/Creazione")
    @ResponseBody
    public String CreateUtente(@RequestParam String Nome,
                               @RequestParam String Cognome,
                               @RequestParam String Email,
                               @RequestParam String Comune,
                               @RequestParam int ruolo,
                               @RequestParam Integer Eta){

        User = new Utente(Nome, Cognome, Email, Eta, IntToRuolo(ruolo));
        return Comune;
    }

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
